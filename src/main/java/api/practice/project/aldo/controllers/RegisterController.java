package api.practice.project.aldo.controllers;

import api.practice.project.aldo.dtos.RegisterRecordDto;
import api.practice.project.aldo.models.RegisterModel;
import api.practice.project.aldo.repositories.RegisterRepository;
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
public class RegisterController {

    @Autowired
    RegisterRepository registerRepository;

    @PostMapping("api/register")
    public ResponseEntity<RegisterModel> saveRegister(@RequestBody @Valid RegisterRecordDto registerRecordDto){
        var registerModel = new RegisterModel();
        BeanUtils.copyProperties(registerRecordDto, registerModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerRepository.save(registerModel));
    }

    @GetMapping("api/register")
    public ResponseEntity<List<RegisterModel>> getAllRegister(){
        return ResponseEntity.status(HttpStatus.OK).body(registerRepository.findAll());
    }
}
