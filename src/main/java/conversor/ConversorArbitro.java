package conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import modelo.Arbitro;
import repositorio.ArbitroRepository;

@FacesConverter(forClass = Arbitro.class)
public class ConversorArbitro implements Converter {

	@Inject
	private ArbitroRepository arbitroRepo;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Arbitro arbitro = null;

		if (value != null) {
			Long id = new Long(value);
			arbitro = arbitroRepo.porId(id);
		}
		return arbitro;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Arbitro) value).getId().toString();
		}

		return "";
	}

}
