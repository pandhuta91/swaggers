package com.example.user.controller;

import com.example.user.model.Student;
import com.example.user.service.StudentService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created * Pandhuta Bangkit S 09/04/2020
 */

@RestController
@RequestMapping(value = "/api/student/")
@Api(value = "API untuk mencari Siswa dari Letak Siswa dengan parameter pencarian berbeda",
        description = "Mendapat dari situs web, dgn method Crawlar dan combine dgn Swagger", produces = "application/json")
public class StudentController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = " Mencari Semua Siswa", produces = "application/json")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllStudents() {
        logger.debug("Mencari Semua Siswa ......");
        List<Student> internationalCustomers = null;
        try {
            internationalCustomers = studentService.getAll();
            logger.debug("Getting All students ...... ::");
        } catch (Exception ex) {
            logger.error("Kesalahan Terjadi searchStudentById >>", ex, ex.getMessage());
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(internationalCustomers, HttpStatus.OK);
    }

    @ApiOperation(value = "Search Siswa by studentId", produces = "application/json")
    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    public ResponseEntity<Object> searchStudentById(
            @ApiParam(name = "studentId",
                    value = "Id dari Siswa untuk dilihat",
                    required = true)
            @PathVariable Integer studentId) {
        logger.debug("Mencari siswa dengan ID Siswa ::" + studentId);
        Student student = null;
        try {
            student = studentService.getStudentById(studentId);
            logger.debug("Siswa di temukan dengan ID ::" + studentId);
        } catch (Exception ex) {
            logger.error("Kesalahan Terjadi dengan ID Siswa >>", ex, ex.getMessage());
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(student, HttpStatus.OK);
    }

    @ApiOperation(value = "Mencari semua Siswa yg usia lebih besar dari usia input", produces = "application/json")
    @RequestMapping(value = "/greaterThanAge/{age}", method = RequestMethod.GET)
    public ResponseEntity<Object> filterStudentsByAge(
            @ApiParam(name = "age",
                    value = "filtering age",
                    required = true) @PathVariable Integer age) {
        List<Student> studentList = null;
        try {
            studentList = studentService.filterByAge(age);
        } catch (Exception ex) {
            logger.error("Kesalahan terjadi oada filter Usia >>", ex, ex.getMessage());
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(studentList, HttpStatus.OK);
    }

    @ApiOperation(value = "Mencari Semua suswa yg berasal dari kota", produces = "application/json")
    @RequestMapping(value = "/fromCity/{cityName}", method = RequestMethod.GET)
    public ResponseEntity<Object> filterStudentsByCity(
            @ApiParam(name = "cityName", value = "filtering city name", required = true)
            @PathVariable String cityName) {
        List<Student> studentList = null;
        try {
            studentList = studentService.filterByCity(cityName);
        } catch (Exception ex) {
            logger.error("Kesalahan terjadi pada >>", ex, ex.getMessage());
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(studentList, HttpStatus.OK);
    }

    @ApiOperation(value = "Cari semua siswa yang berasal dari kota tertentu dan "
            + "yang usianya lebih besar dari usia input", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "schoolId", value = "School Id", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "age", value = "Age of Student", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "cityName", value = "City of Student", required = true, dataType = "String", paramType = "query") })
    @RequestMapping(value = "/filterByAgeAndCity", method = RequestMethod.GET)
    public ResponseEntity<Object> filterStudentsByAgeAndCity(@RequestHeader(name = "schoolId") String userId,
                                                             @RequestParam Integer age,@RequestParam String cityName) {
        List<Student> studentList = null;
        try {
            studentList = studentService.filterByAgeAndCity(age, cityName);
        } catch (Exception ex) {
            logger.error("Kesalahan Terjadi Pada Filter Usia dan Kota >>", ex, ex.getMessage());
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(studentList, HttpStatus.OK);
    }
}
