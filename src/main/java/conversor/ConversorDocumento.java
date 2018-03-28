package conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import modelo.Documento;
import repositorio.DocumentoRepository;

@FacesConverter(forClass = Documento.class)
public class ConversorDocumento implements Converter {

	@Inject
	private DocumentoRepository documentoRepo;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Documento documento = null;

		if (value != null) {
			Long id = new Long(value);
			documento = documentoRepo.porId(id);
		}
		return documento;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Documento) value).getId().toString();
		}

		return "";
	}

}
