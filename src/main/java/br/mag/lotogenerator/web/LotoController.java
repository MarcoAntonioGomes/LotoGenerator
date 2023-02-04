package br.mag.lotogenerator.web;

import br.mag.lotogenerator.dto.GenerateLotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.mag.lotogenerator.services.LotoService;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping(value = "/lotomega/generate")
public class LotoController {

    @Autowired
    private LotoService service;

    @PostMapping
    public ResponseEntity<byte[]> generateXls(@RequestBody GenerateLotoDTO generateLotoDTO, HttpServletResponse response){
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        byte[] content = service.generateLoteMegaSheet(generateLotoDTO.getNumbers());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.set("Content-Disposition", "inline");
        return new ResponseEntity(content, headers, HttpStatus.OK);
    }

}
