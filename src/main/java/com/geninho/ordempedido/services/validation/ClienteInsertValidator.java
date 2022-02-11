package com.geninho.ordempedido.services.validation;

import com.geninho.ordempedido.domain.Cliente;
import com.geninho.ordempedido.domain.enums.TipoCliente;
import com.geninho.ordempedido.dto.ClienteNewDTO;
import com.geninho.ordempedido.repositories.ClienteRepository;
import com.geninho.ordempedido.resources.exception.FieldMessage;
import com.geninho.ordempedido.services.validation.Utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository repo;

    @Override
    public void initialize(ClienteInsert ann) {
    }
    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj","CPF inválido."));
        }

        if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj","CNPJ inválido."));
        }

        Cliente aux = repo.findByEmail(objDto.getEmail());
        if (aux != null){
            list.add(new FieldMessage("email","Email já cadastrado!"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}