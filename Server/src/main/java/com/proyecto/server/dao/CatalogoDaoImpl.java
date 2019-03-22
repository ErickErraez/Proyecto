package com.proyecto.server.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.server.model.Aplicaciones;
import com.proyecto.server.model.Biblioteca;
import com.proyecto.server.model.Catalogo;
import com.proyecto.server.model.Usuarios;

@Repository
@Transactional
public class CatalogoDaoImpl extends AbstractSession implements CatalogoDao {

	@Override
	public Catalogo saveCatalogo(Catalogo catalogo) {
		// TODO Auto-generated method stub
		getSession().persist(catalogo);
		return catalogo;
	}

	@Override
	public void deleteCatalogo(Long idCat) {
		// TODO Auto-generated method stub
		Catalogo catalogo = findById(idCat);
		if (catalogo != null) {
			
			getSession().delete(catalogo);
		}
	}

	@Override
	public Catalogo updateCatalogo(Catalogo catalogo) {
		// TODO Auto-generated method stub
		getSession().update(catalogo);
		return catalogo;
	}

	@Override
	public Catalogo findById(Long idCat) {
		// TODO Auto-generated method stub
		return getSession().get(Catalogo.class, idCat);
	}

	@Override
	public List<Catalogo> findAllAdjuntos() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Catalogo").list();
	}

}
