package com.jtsolv.jtsolvcurr.gamedices.service.ccr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
//@Transaction
public class CCRClientService {

	
	private final RestTemplate restTemplate;
	
	@Autowired
	public CCRClientService(final RestTemplate restTemplate) {
		this.restTemplate =restTemplate;
	}
	
	public String getRatesForCHFForLst30Days() {
		
		return getRates("chf", "2016-04-01","2016-04-30");
	}
	
	public String getFullUrl(final String currency, final String fromDate, final String toDate) {
		return "http://api.nbp.pl/api/exchangerates/rates/c/" + currency + "/" + fromDate +"/" + toDate;
	}
	
	public String getRates(final String currency,String fromDate, String toDate) {

		final String uri = getFullUrl(currency,fromDate,toDate);
		return restTemplate.getForObject(uri, String.class);
		
	}
		
}
