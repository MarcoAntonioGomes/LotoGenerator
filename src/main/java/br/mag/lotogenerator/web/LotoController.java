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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/lotomega/generate")
public class LotoController {

    @Autowired
    private LotoService service;

    @GetMapping
    public ResponseEntity<byte[]> generateXls(@RequestParam("numbers")  int[] numbers, HttpServletResponse response){
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        List<Integer> nums = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());

        byte[] content = service.generateLoteMegaSheet(nums);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.set("Content-Disposition", "inline");
        return new ResponseEntity(content, headers, HttpStatus.OK);
    }

    @RequestMapping("/hello")
    public String index() {
        return "/index.html";
    }


}
