package com.hospital.urgencias.plancuidados.controller;

import com.hospital.urgencias.plancuidados.dto.PlanCuidadosDTO;
import com.hospital.urgencias.plancuidados.service.PlanCuidadosService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.OutputStream;
import java.util.Locale;

@Controller
@RequestMapping("/urgencias/plan-cuidados")
public class PlanCuidadosPrintController {

    private final PlanCuidadosService planCuidadosService;
    private final TemplateEngine templateEngine;

    public PlanCuidadosPrintController(PlanCuidadosService planCuidadosService,
                                       TemplateEngine templateEngine) {
        this.planCuidadosService = planCuidadosService;
        this.templateEngine = templateEngine;
    }

    // Opción A: Abre la vista limpia lista para imprimir desde el navegador (Ctrl+P / window.print)
    @GetMapping("/{idPlan}/imprimir")
    public String vistaImpresion(@PathVariable Long idPlan, Model model) {
        PlanCuidadosDTO plan = planCuidadosService.obtenerPlanCompletoParaImpresion(idPlan);
        model.addAttribute("plan", plan);
        return "urgencias/plan-cuidados-print";
    }

    // Opción B: Descarga directa del PDF generado desde la misma plantilla Thymeleaf
    @GetMapping("/{idPlan}/pdf")
    public void descargarPdf(@PathVariable Long idPlan, HttpServletResponse response) throws Exception {
        PlanCuidadosDTO plan = planCuidadosService.obtenerPlanCompletoParaImpresion(idPlan);

        Context context = new Context(new Locale("es", "CO"));
        context.setVariable("plan", plan);
        String htmlProcesado = templateEngine.process("urgencias/plan-cuidados-print", context);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition",
                "inline; filename=plan-cuidados-" + plan.getPaciente().getHistoriaClinica() + ".pdf");
    }

    @GetMapping("/{idPlan}/editar")
    public String mostrarFormularioEdicion(@PathVariable Long idPlan, Model model) {
        PlanCuidadosDTO plan = planCuidadosService.obtenerPlanCompletoParaImpresion(idPlan);
        model.addAttribute("plan", plan);
        return "urgencias/plan-cuidados-edit";
    }

    @PostMapping("/{idPlan}/editar")
    public String guardarFormularioEdicion(@PathVariable Long idPlan,
                                           @ModelAttribute("plan") PlanCuidadosDTO plan,
                                           RedirectAttributes redirectAttributes) {
        planCuidadosService.guardarCambiosPlan(idPlan, plan);
        redirectAttributes.addFlashAttribute("mensajeExito", "Plan de cuidados actualizado correctamente.");
        return "redirect:/urgencias/plan-cuidados/" + idPlan + "/editar";
    }
}