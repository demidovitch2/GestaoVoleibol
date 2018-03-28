package conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import modelo.Treinador;
import repositorio.TreinadorRepository;

@FacesConverter(forClass = Treinador.class)
public class ConversorTreinador implements Converter {

	@Inject
	private TreinadorRepository treinadorRepo;

	@Override
	public Object getAsObject(FacesContext contex, UIComponent componet, String value) {

		Treinador treinador = null;

		if (value != null) {
			Long id = new Long(value);
			treinador = treinadorRepo.porId(id);
		}
		return treinador;
	}

	@Override
	public String getAsString(FacesContext contex, UIComponent componet, Object value) {
		if (value != null) {
			return ((Treinador) value).getId().toString();
		}

		return "";
	}

}
