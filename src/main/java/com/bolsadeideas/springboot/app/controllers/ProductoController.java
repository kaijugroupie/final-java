package com.bolsadeideas.springboot.app.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Producto;
import com.bolsadeideas.springboot.app.models.service.IProductoService;
import com.bolsadeideas.springboot.app.util.paginator.PageRender;

@Controller
@RequestMapping("/producto")
@SessionAttributes("producto")
public class ProductoController {

	@Autowired
	private IProductoService clienteService;

	@GetMapping(value = "/ver/{id}")
	public String verProducto(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Producto producto = clienteService.findProductoById(id);
		if (producto == null) {
			flash.addFlashAttribute("error", "El Producto no existe en la base de datos.");
			return "redirect:/producto/listar";
		}

		model.put("producto", producto);
		model.put("titulo", "Detalle Producto: " + producto.getNombre());
		return "producto/ver";
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listarProductos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = new PageRequest(page, 4);

		Page<Producto> productos = clienteService.findAllProductos(pageRequest);

		PageRender<Producto> pageRender = new PageRender<Producto>("/producto/listar", productos);
		model.addAttribute("titulo", "Listado de Productos");
		model.addAttribute("productos", productos);
		model.addAttribute("page", pageRender);
		return "producto/listar";
	}

	@RequestMapping(value = "/form")
	public String crearProducto(Map<String, Object> model) {

		Producto producto = new Producto();
		model.put("producto", producto);
		model.put("titulo", "Crear Producto");
		return "producto/form";
	}

	@RequestMapping(value = "/form/{id}")
	public String editarProducto(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Producto producto = null;

		if (id > 0) {
			producto = clienteService.findProductoById(id);
			if (producto == null) {
				flash.addFlashAttribute("error", "El ID del Producto no existe en la base de datos.");
				return "redirect:/producto/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del Producto debe ser distinto a cero.");
			return "redirect:/producto/listar";
		}
		model.put("producto", producto);
		model.put("titulo", "Editar Producto");
		return "producto/form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Producto producto, BindingResult result, Model model,
			RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Productos");
			return "producto/form";
		}

		String mensajeFlash = (producto.getId() != null) ? "¡Producto editado exitosamente!" : "¡Producto creado exitosamente!";

		clienteService.saveProducto(producto);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/producto/listar";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarProducto(@PathVariable(value = "id") Long id, RedirectAttributes flash) throws SQLException {
		
		
		Connection con = DriverManager.getConnection("jdbc:postgresql://ec2-174-129-32-230.compute-1.amazonaws.com:5432/dfpp0fsoq4tfki?useSSL=false", "lwkubqufasdobi", "d482468f41adcf02dcb63bb10608ee995a40c8c5bdebd2f3710485be7dcad6e2");
		Statement stmt = con.createStatement();
		String sqlConsulta = "select * from facturas_items where producto_id = '" + id + "'";
		ResultSet rs = stmt.executeQuery(sqlConsulta);
		if (rs.next()) {
			flash.addFlashAttribute("error", "El Producto no se puede eliminar porque se encuentra en una Factura.");
		} else {
			clienteService.deleteProducto(id);
			flash.addFlashAttribute("success", "¡Producto eliminado exitosamente!");
		}
		return "redirect:/producto/listar";
	}
}
