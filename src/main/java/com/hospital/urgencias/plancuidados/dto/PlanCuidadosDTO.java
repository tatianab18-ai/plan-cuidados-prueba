package com.hospital.urgencias.plancuidados.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlanCuidadosDTO {

    private Long idPlanCuidados;
    private LocalDate fechaPlan;
    private PacienteDTO paciente = new PacienteDTO();
    private IngresoDTO ingreso = new IngresoDTO();
    private DominiosRiesgosDTO dominiosRiesgos = new DominiosRiesgosDTO();
    private DietasFrecuenciaDTO dietasFrecuencia = new DietasFrecuenciaDTO();
    private SeguridadMovilizacionDTO seguridadMovilizacion = new SeguridadMovilizacionDTO();
    private CuidadosSondasDTO cuidadosSondas = new CuidadosSondasDTO();

    // --- Getters y Setters ---
    public Long getIdPlanCuidados() { return idPlanCuidados; }
    public void setIdPlanCuidados(Long idPlanCuidados) { this.idPlanCuidados = idPlanCuidados; }

    public LocalDate getFechaPlan() { return fechaPlan; }
    public void setFechaPlan(LocalDate fechaPlan) { this.fechaPlan = fechaPlan; }

    public PacienteDTO getPaciente() { return paciente; }
    public void setPaciente(PacienteDTO paciente) { this.paciente = paciente; }

    public IngresoDTO getIngreso() { return ingreso; }
    public void setIngreso(IngresoDTO ingreso) { this.ingreso = ingreso; }

    public DominiosRiesgosDTO getDominiosRiesgos() { return dominiosRiesgos; }
    public void setDominiosRiesgos(DominiosRiesgosDTO dominiosRiesgos) { this.dominiosRiesgos = dominiosRiesgos; }

    public DietasFrecuenciaDTO getDietasFrecuencia() { return dietasFrecuencia; }
    public void setDietasFrecuencia(DietasFrecuenciaDTO dietasFrecuencia) { this.dietasFrecuencia = dietasFrecuencia; }

    public SeguridadMovilizacionDTO getSeguridadMovilizacion() { return seguridadMovilizacion; }
    public void setSeguridadMovilizacion(SeguridadMovilizacionDTO seguridadMovilizacion) { this.seguridadMovilizacion = seguridadMovilizacion; }

    public CuidadosSondasDTO getCuidadosSondas() { return cuidadosSondas; }
    public void setCuidadosSondas(CuidadosSondasDTO cuidadosSondas) { this.cuidadosSondas = cuidadosSondas; }

    // --- Clases internas ---
    public static class PacienteDTO {
        private String historiaClinica;
        private String nombres;
        private String apellidos;

        public String getHistoriaClinica() { return historiaClinica; }
        public void setHistoriaClinica(String historiaClinica) { this.historiaClinica = historiaClinica; }
        public String getNombres() { return nombres; }
        public void setNombres(String nombres) { this.nombres = nombres; }
        public String getApellidos() { return apellidos; }
        public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    }

    public static class IngresoDTO {
        private String numeroIngreso;
        private String entidad;
        private String cama;
        private String especialidad;
        private String diagnosticoIngreso;
        private String peso;

        public String getNumeroIngreso() { return numeroIngreso; }
        public void setNumeroIngreso(String numeroIngreso) { this.numeroIngreso = numeroIngreso; }
        public String getEntidad() { return entidad; }
        public void setEntidad(String entidad) { this.entidad = entidad; }
        public String getCama() { return cama; }
        public void setCama(String cama) { this.cama = cama; }
        public String getEspecialidad() { return especialidad; }
        public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
        public String getDiagnosticoIngreso() { return diagnosticoIngreso; }
        public void setDiagnosticoIngreso(String diagnosticoIngreso) { this.diagnosticoIngreso = diagnosticoIngreso; }
        public String getPeso() { return peso; }
        public void setPeso(String peso) { this.peso = peso; }
    }

    public static class DominiosRiesgosDTO {
        private String lesionPielNivel;
        private String comentarios;
        private List<DominioNandaItemDTO> dominios = new ArrayList<>();
        private List<RiesgoClinicoItemDTO> riesgosClinicos = new ArrayList<>();

        public String getLesionPielNivel() { return lesionPielNivel; }
        public void setLesionPielNivel(String lesionPielNivel) { this.lesionPielNivel = lesionPielNivel; }
        public String getComentarios() { return comentarios; }
        public void setComentarios(String comentarios) { this.comentarios = comentarios; }
        public List<DominioNandaItemDTO> getDominios() { return dominios; }
        public void setDominios(List<DominioNandaItemDTO> dominios) { this.dominios = dominios; }
        public List<RiesgoClinicoItemDTO> getRiesgosClinicos() { return riesgosClinicos; }
        public void setRiesgosClinicos(List<RiesgoClinicoItemDTO> riesgosClinicos) { this.riesgosClinicos = riesgosClinicos; }
    }

    public static class DominioNandaItemDTO {
        private String codigoDominio;
        private String nombreDominio;

        public DominioNandaItemDTO() {}
        public DominioNandaItemDTO(String codigoDominio, String nombreDominio) {
            this.codigoDominio = codigoDominio;
            this.nombreDominio = nombreDominio;
        }
        public String getCodigoDominio() { return codigoDominio; }
        public void setCodigoDominio(String codigoDominio) { this.codigoDominio = codigoDominio; }
        public String getNombreDominio() { return nombreDominio; }
        public void setNombreDominio(String nombreDominio) { this.nombreDominio = nombreDominio; }
    }

    public static class RiesgoClinicoItemDTO {
        private String tipoRiesgo;
        private boolean seleccionado;

        public RiesgoClinicoItemDTO() {}
        public RiesgoClinicoItemDTO(String tipoRiesgo, boolean seleccionado) {
            this.tipoRiesgo = tipoRiesgo;
            this.seleccionado = seleccionado;
        }
        public String getTipoRiesgo() { return tipoRiesgo; }
        public void setTipoRiesgo(String tipoRiesgo) { this.tipoRiesgo = tipoRiesgo; }
        public boolean isSeleccionado() { return seleccionado; }
        public void setSeleccionado(boolean seleccionado) { this.seleccionado = seleccionado; }
    }

    public static class DietasFrecuenciaDTO {
        private String dietaIndicada;
        private boolean dejarCena;
        private boolean asistida;
        private boolean oxigenoterapiaActivo;
        private String soporteOxigeno;
        private FrecuenciaMonitoreoDTO frecuenciaMonitoreo = new FrecuenciaMonitoreoDTO();

        public String getDietaIndicada() { return dietaIndicada; }
        public void setDietaIndicada(String dietaIndicada) { this.dietaIndicada = dietaIndicada; }
        public boolean isDejarCena() { return dejarCena; }
        public void setDejarCena(boolean dejarCena) { this.dejarCena = dejarCena; }
        public boolean isAsistida() { return asistida; }
        public void setAsistida(boolean asistida) { this.asistida = asistida; }
        public boolean isOxigenoterapiaActivo() { return oxigenoterapiaActivo; }
        public void setOxigenoterapiaActivo(boolean oxigenoterapiaActivo) { this.oxigenoterapiaActivo = oxigenoterapiaActivo; }
        public String getSoporteOxigeno() { return soporteOxigeno; }
        public void setSoporteOxigeno(String soporteOxigeno) { this.soporteOxigeno = soporteOxigeno; }
        public FrecuenciaMonitoreoDTO getFrecuenciaMonitoreo() { return frecuenciaMonitoreo; }
        public void setFrecuenciaMonitoreo(FrecuenciaMonitoreoDTO frecuenciaMonitoreo) { this.frecuenciaMonitoreo = frecuenciaMonitoreo; }
    }

    public static class FrecuenciaMonitoreoDTO {
        private int signosVitalesCada;
        private int curvaTempCada;
        private int glasgowCada;
        private String posicion;

        public int getSignosVitalesCada() { return signosVitalesCada; }
        public void setSignosVitalesCada(int signosVitalesCada) { this.signosVitalesCada = signosVitalesCada; }
        public int getCurvaTempCada() { return curvaTempCada; }
        public void setCurvaTempCada(int curvaTempCada) { this.curvaTempCada = curvaTempCada; }
        public int getGlasgowCada() { return glasgowCada; }
        public void setGlasgowCada(int glasgowCada) { this.glasgowCada = glasgowCada; }
        public String getPosicion() { return posicion; }
        public void setPosicion(String posicion) { this.posicion = posicion; }
    }

    public static class SeguridadMovilizacionDTO {
        private boolean medidaSujecion;
        private boolean movilizarCama;
        private boolean movilizarSilla;
        private boolean movilizarDeambular;
        private boolean curacionActivo;
        private List<AislamientoItemDTO> aislamientos = new ArrayList<>();
        private List<CuracionItemDTO> curaciones = new ArrayList<>();

        public boolean isMedidaSujecion() { return medidaSujecion; }
        public void setMedidaSujecion(boolean medidaSujecion) { this.medidaSujecion = medidaSujecion; }
        public boolean isMovilizarCama() { return movilizarCama; }
        public void setMovilizarCama(boolean movilizarCama) { this.movilizarCama = movilizarCama; }
        public boolean isMovilizarSilla() { return movilizarSilla; }
        public void setMovilizarSilla(boolean movilizarSilla) { this.movilizarSilla = movilizarSilla; }
        public boolean isMovilizarDeambular() { return movilizarDeambular; }
        public void setMovilizarDeambular(boolean movilizarDeambular) { this.movilizarDeambular = movilizarDeambular; }
        public boolean isCuracionActivo() { return curacionActivo; }
        public void setCuracionActivo(boolean curacionActivo) { this.curacionActivo = curacionActivo; }
        public List<AislamientoItemDTO> getAislamientos() { return aislamientos; }
        public void setAislamientos(List<AislamientoItemDTO> aislamientos) { this.aislamientos = aislamientos; }
        public List<CuracionItemDTO> getCuraciones() { return curaciones; }
        public void setCuraciones(List<CuracionItemDTO> curaciones) { this.curaciones = curaciones; }
    }

    public static class AislamientoItemDTO {
        private String tipoAislamiento;
        private LocalDate fechaInicio;
        private LocalDate fechaTerminacion;

        public String getTipoAislamiento() { return tipoAislamiento; }
        public void setTipoAislamiento(String tipoAislamiento) { this.tipoAislamiento = tipoAislamiento; }
        public LocalDate getFechaInicio() { return fechaInicio; }
        public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
        public LocalDate getFechaTerminacion() { return fechaTerminacion; }
        public void setFechaTerminacion(LocalDate fechaTerminacion) { this.fechaTerminacion = fechaTerminacion; }
    }

    public static class CuracionItemDTO {
        private String tipoCuracion;
        private String escribirEnfermeria;
        private LocalDate fechaComite;

        public String getTipoCuracion() { return tipoCuracion; }
        public void setTipoCuracion(String tipoCuracion) { this.tipoCuracion = tipoCuracion; }
        public String getEscribirEnfermeria() { return escribirEnfermeria; }
        public void setEscribirEnfermeria(String escribirEnfermeria) { this.escribirEnfermeria = escribirEnfermeria; }
        public LocalDate getFechaComite() { return fechaComite; }
        public void setFechaComite(LocalDate fechaComite) { this.fechaComite = fechaComite; }
    }

    public static class CuidadosSondasDTO {
        private boolean sondaVesicalActivo;
        private LocalDate fechaCambioVesical;
        private String cateterismoCadaHoras;
        private List<HoraCateterismoItemDTO> horasCateterismo = new ArrayList<>();
        private List<SondaItemDTO> sondas = new ArrayList<>();
        private List<AccesoVenosoItemDTO> accesosVenosos = new ArrayList<>();

        public boolean isSondaVesicalActivo() { return sondaVesicalActivo; }
        public void setSondaVesicalActivo(boolean sondaVesicalActivo) { this.sondaVesicalActivo = sondaVesicalActivo; }
        public LocalDate getFechaCambioVesical() { return fechaCambioVesical; }
        public void setFechaCambioVesical(LocalDate fechaCambioVesical) { this.fechaCambioVesical = fechaCambioVesical; }
        public String getCateterismoCadaHoras() { return cateterismoCadaHoras; }
        public void setCateterismoCadaHoras(String cateterismoCadaHoras) { this.cateterismoCadaHoras = cateterismoCadaHoras; }
        public List<HoraCateterismoItemDTO> getHorasCateterismo() { return horasCateterismo; }
        public void setHorasCateterismo(List<HoraCateterismoItemDTO> horasCateterismo) { this.horasCateterismo = horasCateterismo; }
        public List<SondaItemDTO> getSondas() { return sondas; }
        public void setSondas(List<SondaItemDTO> sondas) { this.sondas = sondas; }
        public List<AccesoVenosoItemDTO> getAccesosVenosos() { return accesosVenosos; }
        public void setAccesosVenosos(List<AccesoVenosoItemDTO> accesosVenosos) { this.accesosVenosos = accesosVenosos; }
    }

    public static class HoraCateterismoItemDTO {
        private int horaAplicacion;
        public HoraCateterismoItemDTO() {}
        public HoraCateterismoItemDTO(int horaAplicacion) { this.horaAplicacion = horaAplicacion; }
        public int getHoraAplicacion() { return horaAplicacion; }
        public void setHoraAplicacion(int horaAplicacion) { this.horaAplicacion = horaAplicacion; }
    }

    public static class SondaItemDTO {
        private String tipoSonda;
        private boolean seleccionado;
        private LocalDate fechaInsercion;

        public String getTipoSonda() { return tipoSonda; }
        public void setTipoSonda(String tipoSonda) { this.tipoSonda = tipoSonda; }
        public boolean isSeleccionado() { return seleccionado; }
        public void setSeleccionado(boolean seleccionado) { this.seleccionado = seleccionado; }
        public LocalDate getFechaInsercion() { return fechaInsercion; }
        public void setFechaInsercion(LocalDate fechaInsercion) { this.fechaInsercion = fechaInsercion; }
    }

    public static class AccesoVenosoItemDTO {
        private String tipoAcceso;
        private boolean seleccionado;
        private LocalDate fechaInicio;

        public String getTipoAcceso() { return tipoAcceso; }
        public void setTipoAcceso(String tipoAcceso) { this.tipoAcceso = tipoAcceso; }
        public boolean isSeleccionado() { return seleccionado; }
        public void setSeleccionado(boolean seleccionado) { this.seleccionado = seleccionado; }
        public LocalDate getFechaInicio() { return fechaInicio; }
        public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    }
}