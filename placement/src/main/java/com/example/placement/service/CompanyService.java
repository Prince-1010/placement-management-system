package com.example.placement.service;

import com.example.placement.entity.CompanyEntity;
import com.example.placement.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity saveCompany(CompanyEntity company){
        return companyRepository.save(company);
    }
    public List<CompanyEntity>getAllCompany(){
        return companyRepository.findAll();
    }
    public void deleteCompany(Long id){
        companyRepository.deleteById(id);
    }

}
