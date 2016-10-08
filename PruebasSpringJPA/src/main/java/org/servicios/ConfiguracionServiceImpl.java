package org.servicios;

import java.util.List;

import org.model.ConfigMensaje;
import org.repositorios.ConfigMensajeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfiguracionServiceImpl implements ConfiguracionService {

	
	private ConfigMensajeRepositorio configurationRepository;

    @Autowired
    public void setConfigurationRepository(ConfigMensajeRepositorio configurationRepository) {
        this.configurationRepository = configurationRepository;
    }
	
	@Override
	public List<ConfigMensaje> findByMensajeOrigen(String mensajeOrigen) {
		
		return configurationRepository.findByMensajeOrigen(mensajeOrigen);
	}

}
