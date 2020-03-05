package com.gm.base.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gm.base.entities.ClientSeqPrefix;
import com.gm.base.repositories.ClientSeqPrefixRepository;
import com.gm.base.services.ClientSeqPrefixService;

@Service
public class ClientSeqPrefixServiceImpl implements ClientSeqPrefixService{

	@Autowired
	ClientSeqPrefixRepository clientSeqPrefixRepository;

	@Value("#{'${gm.client.prefix}'.split(',')}") 
	private List<String> prefixes; 
	
	@Override
	public void loadAllClients() {
		for(String prefix : prefixes) {
			Optional<ClientSeqPrefix> optional = clientSeqPrefixRepository.findById(prefix);
			if(!optional.isPresent()) {
				ClientSeqPrefix clientSeqPrefix = new ClientSeqPrefix();
				clientSeqPrefix.setClientId(prefix.split("#")[0]);
				clientSeqPrefix.setPrefix(Integer.parseInt(prefix.split("#")[1]));
				clientSeqPrefix.setPrefixString(prefix.split("#")[2]);
				clientSeqPrefixRepository.save(clientSeqPrefix);
			}
		}
	}
}
