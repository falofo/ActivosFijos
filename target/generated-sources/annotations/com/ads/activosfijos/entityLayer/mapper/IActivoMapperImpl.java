package com.ads.activosfijos.entityLayer.mapper;

import com.ads.activosfijos.entityLayer.Activo;
import com.ads.activosfijos.entityLayer.Caracteristicas;
import com.ads.activosfijos.entityLayer.Dueno;
import com.ads.activosfijos.entityLayer.Estado;
import com.ads.activosfijos.entityLayer.Tipo;
import com.ads.activosfijos.entityLayer.dto.ActivoDTO;
import com.ads.activosfijos.entityLayer.dto.ActivoDTO.TipoDueno;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-11-12T12:45:27-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class IActivoMapperImpl implements IActivoMapper {

    @Override
    public ActivoDTO activoToActivoDTO(Activo activo) {
        if ( activo == null ) {
            return null;
        }

        ActivoDTO activoDTO = new ActivoDTO();

        String color = activoCaracteristicasColor( activo );
        if ( color != null ) {
            activoDTO.setColor( color );
        }
        Double peso = activoCaracteristicasPeso( activo );
        if ( peso != null ) {
            activoDTO.setPeso( peso );
        }
        Double ancho = activoCaracteristicasAncho( activo );
        if ( ancho != null ) {
            activoDTO.setAncho( ancho );
        }
        String tipo = activoIdduenoTipo( activo );
        if ( tipo != null ) {
            activoDTO.setTipoDueno( Enum.valueOf( TipoDueno.class, tipo ) );
        }
        Double largo = activoCaracteristicasLargo( activo );
        if ( largo != null ) {
            activoDTO.setLargo( largo );
        }
        Double alto = activoCaracteristicasAlto( activo );
        if ( alto != null ) {
            activoDTO.setAlto( alto );
        }
        Integer idtipo = activoIdtipoIdtipo( activo );
        if ( idtipo != null ) {
            activoDTO.setIdtipo( idtipo );
        }
        Integer iddueno = activoIdduenoIddueno( activo );
        if ( iddueno != null ) {
            activoDTO.setIdDueno( iddueno );
        }
        Integer idestado = activoIdestadoIdestado( activo );
        if ( idestado != null ) {
            activoDTO.setIdestado( idestado );
        }
        activoDTO.setIdactivo( activo.getIdactivo() );
        activoDTO.setNombre( activo.getNombre() );
        activoDTO.setDescripcion( activo.getDescripcion() );
        activoDTO.setSerial( activo.getSerial() );
        activoDTO.setNumeroInterno( activo.getNumeroInterno() );
        activoDTO.setValorCompra( activo.getValorCompra() );
        activoDTO.setFechaCompra( activo.getFechaCompra() );

        return activoDTO;
    }

    @Override
    public Activo activoDTOToActivo(ActivoDTO activo) {
        if ( activo == null ) {
            return null;
        }

        Activo activo1 = new Activo();

        activo1.setIddueno( activoDTOToDueno( activo ) );
        activo1.setCaracteristicas( activoDTOToCaracteristicas( activo ) );
        activo1.setIdtipo( activoDTOToTipo( activo ) );
        activo1.setIdestado( activoDTOToEstado( activo ) );
        activo1.setIdactivo( activo.getIdactivo() );
        activo1.setNombre( activo.getNombre() );
        activo1.setDescripcion( activo.getDescripcion() );
        activo1.setSerial( activo.getSerial() );
        if ( activo.getNumeroInterno() != null ) {
            activo1.setNumeroInterno( activo.getNumeroInterno() );
        }
        if ( activo.getValorCompra() != null ) {
            activo1.setValorCompra( activo.getValorCompra() );
        }
        activo1.setFechaCompra( activo.getFechaCompra() );

        return activo1;
    }

    private String activoCaracteristicasColor(Activo activo) {
        if ( activo == null ) {
            return null;
        }
        Caracteristicas caracteristicas = activo.getCaracteristicas();
        if ( caracteristicas == null ) {
            return null;
        }
        String color = caracteristicas.getColor();
        if ( color == null ) {
            return null;
        }
        return color;
    }

    private Double activoCaracteristicasPeso(Activo activo) {
        if ( activo == null ) {
            return null;
        }
        Caracteristicas caracteristicas = activo.getCaracteristicas();
        if ( caracteristicas == null ) {
            return null;
        }
        Double peso = caracteristicas.getPeso();
        if ( peso == null ) {
            return null;
        }
        return peso;
    }

    private Double activoCaracteristicasAncho(Activo activo) {
        if ( activo == null ) {
            return null;
        }
        Caracteristicas caracteristicas = activo.getCaracteristicas();
        if ( caracteristicas == null ) {
            return null;
        }
        Double ancho = caracteristicas.getAncho();
        if ( ancho == null ) {
            return null;
        }
        return ancho;
    }

    private String activoIdduenoTipo(Activo activo) {
        if ( activo == null ) {
            return null;
        }
        Dueno iddueno = activo.getIddueno();
        if ( iddueno == null ) {
            return null;
        }
        String tipo = iddueno.getTipo();
        if ( tipo == null ) {
            return null;
        }
        return tipo;
    }

    private Double activoCaracteristicasLargo(Activo activo) {
        if ( activo == null ) {
            return null;
        }
        Caracteristicas caracteristicas = activo.getCaracteristicas();
        if ( caracteristicas == null ) {
            return null;
        }
        Double largo = caracteristicas.getLargo();
        if ( largo == null ) {
            return null;
        }
        return largo;
    }

    private Double activoCaracteristicasAlto(Activo activo) {
        if ( activo == null ) {
            return null;
        }
        Caracteristicas caracteristicas = activo.getCaracteristicas();
        if ( caracteristicas == null ) {
            return null;
        }
        Double alto = caracteristicas.getAlto();
        if ( alto == null ) {
            return null;
        }
        return alto;
    }

    private Integer activoIdtipoIdtipo(Activo activo) {
        if ( activo == null ) {
            return null;
        }
        Tipo idtipo = activo.getIdtipo();
        if ( idtipo == null ) {
            return null;
        }
        Integer idtipo1 = idtipo.getIdtipo();
        if ( idtipo1 == null ) {
            return null;
        }
        return idtipo1;
    }

    private Integer activoIdduenoIddueno(Activo activo) {
        if ( activo == null ) {
            return null;
        }
        Dueno iddueno = activo.getIddueno();
        if ( iddueno == null ) {
            return null;
        }
        Integer iddueno1 = iddueno.getIddueno();
        if ( iddueno1 == null ) {
            return null;
        }
        return iddueno1;
    }

    private Integer activoIdestadoIdestado(Activo activo) {
        if ( activo == null ) {
            return null;
        }
        Estado idestado = activo.getIdestado();
        if ( idestado == null ) {
            return null;
        }
        Integer idestado1 = idestado.getIdestado();
        if ( idestado1 == null ) {
            return null;
        }
        return idestado1;
    }

    protected Dueno activoDTOToDueno(ActivoDTO activoDTO) {
        if ( activoDTO == null ) {
            return null;
        }

        Dueno dueno = new Dueno();

        dueno.setIddueno( activoDTO.getIdDueno() );
        if ( activoDTO.getTipoDueno() != null ) {
            dueno.setTipo( activoDTO.getTipoDueno().name() );
        }

        return dueno;
    }

    protected Caracteristicas activoDTOToCaracteristicas(ActivoDTO activoDTO) {
        if ( activoDTO == null ) {
            return null;
        }

        Caracteristicas caracteristicas = new Caracteristicas();

        caracteristicas.setAlto( activoDTO.getAlto() );
        caracteristicas.setColor( activoDTO.getColor() );
        caracteristicas.setPeso( activoDTO.getPeso() );
        caracteristicas.setAncho( activoDTO.getAncho() );
        caracteristicas.setLargo( activoDTO.getLargo() );

        return caracteristicas;
    }

    protected Tipo activoDTOToTipo(ActivoDTO activoDTO) {
        if ( activoDTO == null ) {
            return null;
        }

        Tipo tipo = new Tipo();

        tipo.setIdtipo( activoDTO.getIdtipo() );

        return tipo;
    }

    protected Estado activoDTOToEstado(ActivoDTO activoDTO) {
        if ( activoDTO == null ) {
            return null;
        }

        Estado estado = new Estado();

        estado.setIdestado( activoDTO.getIdestado() );

        return estado;
    }
}
