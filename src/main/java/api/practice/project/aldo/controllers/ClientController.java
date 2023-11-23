package api.practice.project.aldo.controllers;

import api.practice.project.aldo.dtos.ClientRecordDto;
import api.practice.project.aldo.models.ClientModel;
import api.practice.project.aldo.repositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @PostMapping("api/client")
    public ResponseEntity<ClientModel> saveClient(@RequestBody @Valid ClientRecordDto clientRecordDto){
        var clientModel = new ClientModel();
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(clientModel));
    }

    @GetMapping("api/client")
    public ResponseEntity<List<ClientModel>> getAllClient(){
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.findAll());
    }
}
