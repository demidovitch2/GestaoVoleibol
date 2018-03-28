package conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import modelo.Atleta;
import repositorio.AtletaRepository;

@FacesConverter(forClass = Atleta.class)
public class ConversorAtleta implements Converter {

	@Inject
	private AtletaRepository atletaRepo;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Atleta atleta = null;

		if (value != null) {
			Long id = new Long(value);
			atleta = atletaRepo.porId(id);
		}
		return atleta;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Atleta) value).getId().toString();
		}

		return "";
	}

}
