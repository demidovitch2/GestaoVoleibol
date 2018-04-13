package conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import modelo.Grupo;
import repositorio.GrupoRepository;

@FacesConverter(forClass = Grupo.class)
public class ConversorGrupo implements Converter {

	@Inject
	private GrupoRepository grupoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Grupo grupo = null;

		if (value != null) {
			Long id = new Long(value);
			grupo = grupoRepository.porId(id);
		}
		return grupo;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Grupo) value).getId().toString();
		}

		return "";
	}
}
