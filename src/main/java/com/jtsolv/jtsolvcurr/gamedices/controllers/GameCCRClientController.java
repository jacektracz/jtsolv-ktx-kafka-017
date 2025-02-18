package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.service.ccr.CCRClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ccr")
@CrossOrigin
public class GameCCRClientController {


	private final CCRClientService clientService;
	
	@Autowired
	public GameCCRClientController(final CCRClientService ccrClientService) {
		this.clientService = ccrClientService;
	}
	
    @GetMapping("/rateseur30")
    public ResponseEntity<String> getRatesForCHFForLst30Days() {
        final String data = clientService.getRatesForCHFForLst30Days();
        return new ResponseEntity<String>(data,HttpStatus.OK);
    }
	
		
}
