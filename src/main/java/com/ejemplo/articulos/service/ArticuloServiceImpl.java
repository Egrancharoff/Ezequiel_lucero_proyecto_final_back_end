
package com.ejemplo.articulos.service;

import com.ejemplo.articulos.model.Articulo;
import com.ejemplo.articulos.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // Marca la clase como servicio de Spring
public class ArticuloServiceImpl implements ArticuloService {

    private final ArticuloRepository articuloRepository;

    public ArticuloServiceImpl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }
    
    @Override
    public List<Articulo> listarArticulos() {
        return articuloRepository.findAll();
    }

    @Override
    public Optional<Articulo> obtenerArticuloPorId(Long id) {
        return articuloRepository.findById(Objects.requireNonNull(id, "El id no puede ser nulo"));
    }

    @Override
    public Articulo guardarArticulo(Articulo articulo) {
        return articuloRepository.save(Objects.requireNonNull(articulo, "El articulo no puede ser nulo"));
    }
    @Override
    public Articulo actualizarArticulo(Long id, Articulo articulo) {
        Long idSeguro = Objects.requireNonNull(id, "El id no puede ser nulo");
        Articulo articuloSeguro = Objects.requireNonNull(articulo, "El articulo no puede ser nulo");
        articuloSeguro.setId(idSeguro);
        return articuloRepository.save(articuloSeguro);
    }
    @Override
    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(Objects.requireNonNull(id, "El id no puede ser nulo"));
    }
}
