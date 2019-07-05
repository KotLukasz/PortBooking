package portbooking.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import portbooking.entity.PortOwner;
import portbooking.repository.PortOwnerRepository;


@Component
public class PortOwnerConverter implements Converter<String, PortOwner> {

	@Autowired
	private PortOwnerRepository portOwnerRepository;

	@Override
	public PortOwner convert(String s) {
		return portOwnerRepository.findOne(Long.valueOf(s));
	}

}