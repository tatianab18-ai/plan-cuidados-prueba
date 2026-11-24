package com.hospital.urgencias.plancuidados.service;

import com.hospital.urgencias.plancuidados.dto.PlanCuidadosDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PlanCuidadosService {

    private final Map<Long, PlanCuidadosDTO> planesEnMemoria = new ConcurrentHashMap<>();

    public PlanCuidadosDTO obtenerPlanCompletoParaImpresion(Long idPlan) {
        return planesEnMemoria.computeIfAbsent(idPlan, this::crearPlanDePrueba);
    }

    public PlanCuidadosDTO guardarCambiosPlan(Long idPlan, PlanCuidadosDTO planActualizado) {
        planActualizado.setIdPlanCuidados(idPlan);
        if (planActualizado.getFechaPlan() == null) {
            planActualizado.setFechaPlan(LocalDate.now());
        }
        planesEnMemoria.put(idPlan, planActualizado);
        return planActualizado;
    }

    private PlanCuidadosDTO crearPlanDePrueba(Long idPlan) {
        PlanCuidadosDTO dto = new PlanCuidadosDTO();
        dto.setIdPlanCuidados(idPlan);
        dto.setFechaPlan(LocalDate.now());

        dto.getPaciente().setHistoriaClinica("1061789456");
        dto.getPaciente().setNombres("Carlos Andrés");
        dto.getPaciente().setApellidos("Muñoz Ortega");

        dto.getIngreso().setNumeroIngreso("ING-2026-0048");
        dto.getIngreso().setEntidad("Nueva EPS");
        dto.getIngreso().setCama("URG-07");
        dto.getIngreso().setEspecialidad("Medicina de Urgencias");
        dto.getIngreso().setDiagnosticoIngreso("Observación clínica en servicio de urgencias");
        dto.getIngreso().setPeso("72");

        dto.getDominiosRiesgos().setLesionPielNivel("Medio");
        dto.getDominiosRiesgos().setComentarios("Mantener barandas elevadas y vigilancia continua.");
        dto.getDominiosRiesgos().setDominios(List.of(
                new PlanCuidadosDTO.DominioNandaItemDTO("DOM-11", "Seguridad / protección")
        ));
        dto.getDominiosRiesgos().setRiesgosClinicos(List.of(
                new PlanCuidadosDTO.RiesgoClinicoItemDTO("Caídas", true),
                new PlanCuidadosDTO.RiesgoClinicoItemDTO("Flebitis", true)
        ));

        dto.getDietasFrecuencia().setDietaIndicada("Dieta blanda hiposódica");
        dto.getDietasFrecuencia().setDejarCena(true);
        dto.getDietasFrecuencia().setAsistida(false);
        dto.getDietasFrecuencia().setOxigenoterapiaActivo(true);
        dto.getDietasFrecuencia().setSoporteOxigeno("Cánula nasal a 2 L/min");
        dto.getDietasFrecuencia().getFrecuenciaMonitoreo().setSignosVitalesCada(4);
        dto.getDietasFrecuencia().getFrecuenciaMonitoreo().setCurvaTempCada(6);
        dto.getDietasFrecuencia().getFrecuenciaMonitoreo().setGlasgowCada(4);
        dto.getDietasFrecuencia().getFrecuenciaMonitoreo().setPosicion("Fowler / Semi-Fowler (30° - 45°)");

        dto.getSeguridadMovilizacion().setMovilizarCama(true);
        dto.getSeguridadMovilizacion().setMovilizarSilla(true);

        dto.getCuidadosSondas().setSondaVesicalActivo(true);
        dto.getCuidadosSondas().setCateterismoCadaHoras("6 horas");
        dto.getCuidadosSondas().setHorasCateterismo(List.of(
                new PlanCuidadosDTO.HoraCateterismoItemDTO(8),
                new PlanCuidadosDTO.HoraCateterismoItemDTO(14),
                new PlanCuidadosDTO.HoraCateterismoItemDTO(20)
        ));

        return dto;
    }
}