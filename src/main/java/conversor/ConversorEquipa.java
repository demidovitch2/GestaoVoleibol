package conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import modelo.Equipa;
import repositorio.EquipaRepository;

@FacesConverter(forClass = Equipa.class)
public class ConversorEquipa implements Converter {

	@Inject
	private EquipaRepository equipaRepo;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Equipa equipa = null;

		if (value != null) {
			Long id = new Long(value);
			equipa = equipaRepo.porId(id);
		}
		return equipa;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Equipa) value).getId().toString();
		}

		return "";
	}

}
