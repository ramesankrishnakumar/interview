package interview.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Subdomain_visit_count_811 {
	class Solution {
	    Map<String, Long> hitCount = new HashMap<>();
	    public List<String> subdomainVisits(String[] cpdomains) {
	        for(String cpdomain :  cpdomains) {
	            String[] cpdSplit = cpdomain.split(" ");
	            Long count = Long.valueOf(cpdSplit[0]);
	            String [] subDomains = cpdSplit[1].split("\\.");
	            String curr = null;
	            for(int i = subDomains.length - 1; i >= 0 ; i--) {
	                curr = subDomains[i] + (null != curr ? ("." + curr) : "");
	                hitCount.compute(curr, (k, v) -> {
	                    if(v == null) return count;
	                    return v + count;
	                });
	            }
	        }
	        
	        return hitCount.entrySet()
	            .stream().map(a -> a.getValue() + " " + a.getKey())
	            .collect(Collectors.toList());
	        
	    }
	}
}
