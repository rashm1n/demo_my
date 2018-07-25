package it.codegen.rnd.assetTracking.controller;

import it.codegen.rnd.assetTracking.dbModels.Asset;
import it.codegen.rnd.assetTracking.provider.DataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.NoSuchElementException;

@RestController
public class controller {

    @Autowired
    DataAccess dataAccess;

    @GetMapping("/")
    public void ss(){
        System.out.println("Hi");
    }

//    @GetMapping("/insert")
//    public ResponseEntity<Asset> insertAsset(@RequestParam (value = "aN") String aN , @RequestParam(value = "catagory") String catagory, @RequestParam(value = "owner") String owner , @RequestParam(value = "location") String location){
//        try {
//            Asset asset = dataAccess.insertAssetToDB(aN,true,new Date(),catagory,owner,location);
//            return new ResponseEntity<Asset>(asset, HttpStatus.OK);
//        }catch (NoSuchElementException e){
//            return new ResponseEntity<Asset>(HttpStatus.NOT_FOUND);
//        }
//
//    }

}
