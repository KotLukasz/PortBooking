package portbooking.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import portbooking.entity.Port;
import portbooking.repository.PortRepository;

@Component
public class PortConverter implements Converter<String, Port> {

	@Autowired
	private PortRepository portRepository;

	@Override
	public Port convert(String s) {
		return portRepository.findOne(Long.valueOf(s));
	}

}
