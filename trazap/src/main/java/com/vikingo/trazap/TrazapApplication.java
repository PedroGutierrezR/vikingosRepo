package com.vikingo.trazap;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vikingo.trazap.app.repository.BodegaRepository;
import com.vikingo.trazap.app.repository.CategoriaProductoRepository;
import com.vikingo.trazap.app.repository.DetallePedidoRepository;
import com.vikingo.trazap.app.repository.EstadoTrazabilidadRepository;
import com.vikingo.trazap.app.repository.PedidosRepository;
import com.vikingo.trazap.app.repository.ProductoProveedorRepository;
import com.vikingo.trazap.app.repository.ProductoRepository;
import com.vikingo.trazap.app.repository.ProductosBodegaRepository;
import com.vikingo.trazap.app.repository.ProveedorRepository;
import com.vikingo.trazap.app.repository.RolRepository;
import com.vikingo.trazap.app.repository.TipoProductoRepository;
import com.vikingo.trazap.app.repository.TrazabilidadRepository;
import com.vikingo.trazap.app.repository.UsuarioRepository;
import com.vikingo.trazap.app.repository.model.Bodega;
import com.vikingo.trazap.app.repository.model.CategoriaProducto;
import com.vikingo.trazap.app.repository.model.DetallePedido;
import com.vikingo.trazap.app.repository.model.EstadoTrazabilidad;
import com.vikingo.trazap.app.repository.model.Pedidos;
import com.vikingo.trazap.app.repository.model.Producto;
import com.vikingo.trazap.app.repository.model.ProductoProveedor;
import com.vikingo.trazap.app.repository.model.ProductosBodega;
import com.vikingo.trazap.app.repository.model.Proveedor;
import com.vikingo.trazap.app.repository.model.Rol;
import com.vikingo.trazap.app.repository.model.TipoProducto;
import com.vikingo.trazap.app.repository.model.Trazabilidad;
import com.vikingo.trazap.app.repository.model.Usuario;

@SpringBootApplication
public class TrazapApplication {

	private static final Logger logger = LoggerFactory.getLogger(TrazapApplication.class);
	
	@Autowired
	private BodegaRepository bodegaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RolRepository rolRepository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	@Autowired
	private ProductosBodegaRepository productosBodegaRepository;
	@Autowired
	private CategoriaProductoRepository categoriaProductoRepository;
	@Autowired
	private TipoProductoRepository tipoProductoRepository;
	@Autowired
	private ProveedorRepository proveedorRepository;
	@Autowired
	private ProductoProveedorRepository productoProveedorRepository;
	@Autowired
	private PedidosRepository pedidosRepository;
	@Autowired
	private EstadoTrazabilidadRepository estadoTrazabilidadRepository;
	@Autowired
	private TrazabilidadRepository trazabilidadRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(TrazapApplication.class, args);
	}

	@Bean
	public CommandLineRunner createProducto() {
		return (args) -> {
//			Producto producto = new Producto();
//			CategoriaProducto categoriaProducto = new CategoriaProducto();
//			TipoProducto tipoProducto = new TipoProducto();
//			
//			categoriaProducto.setDescripcion("Limpieza");
//			categoriaProductoRepository.save(categoriaProducto);
//			
//			tipoProducto.setDescripcion("Jabón");
//			tipoProductoRepository.save(tipoProducto);
//			
//			producto.setDescripcion("piel sensible");
//			producto.setCategoriaProducto(categoriaProducto);
//			producto.setTipoProducto(tipoProducto);
//			
//			productoRepository.save(producto);
//			logger.info(producto.toString());
			
		};
	}
	
	@Bean
	public CommandLineRunner createProductoProveedor() {
		return (args) -> {
			
//			Proveedor proveedor = new Proveedor();
//			proveedor.setRazon_social("Distribuidora por mayor");
//			proveedor.setRut_proveedor("1-9");
//			proveedorRepository.save(proveedor);
//			logger.info(proveedor.toString());
//			
//			ProductoProveedor productoProveedor = new ProductoProveedor();
//			productoProveedor.setProveedor(proveedor);
//			productoProveedorRepository.save(productoProveedor);
//			logger.info(productoProveedor.toString());
			
		};
	}
	
	@Bean
	public CommandLineRunner createTrazabilidad() {
		return (args) -> {
			
			Pedidos pedidos = new Pedidos();
			pedidos.setFecha_ingreso(LocalDate.now());
			pedidos.setFecha_recibido(LocalDate.now());
			pedidosRepository.save(pedidos);
			logger.info(pedidos.toString());
			
			Proveedor proveedor = new Proveedor();
			proveedor.setRazon_social("Distribuidora por mayor");
			proveedor.setRut_proveedor("1-9");
			proveedorRepository.save(proveedor);
			logger.info(proveedor.toString());
			
			Producto producto = new Producto();
			CategoriaProducto categoriaProducto = new CategoriaProducto();
			TipoProducto tipoProducto = new TipoProducto();
			
			categoriaProducto.setDescripcion("Limpieza");
			categoriaProductoRepository.save(categoriaProducto);
			
			tipoProducto.setDescripcion("Jabón");
			tipoProductoRepository.save(tipoProducto);
			
			producto.setDescripcion("piel sensible");
			producto.setCategoriaProducto(categoriaProducto);
			producto.setTipoProducto(tipoProducto);
			
			productoRepository.save(producto);
			logger.info(producto.toString());
			
			Bodega bodega1 = new Bodega();	
			bodega1.setDescripcion("Mi Bodega original 1");
			bodegaRepository.save(bodega1);
			logger.info(bodega1.toString());
			
			ProductosBodega productosBodega = new ProductosBodega();
			productosBodega.setBodega(bodega1);
			productosBodega.setProducto(producto);
			productosBodega.setStock(1000);
			productosBodegaRepository.save(productosBodega);
			logger.info(productosBodega.toString());
			
			ProductoProveedor productoProveedor = new ProductoProveedor();
			productoProveedor.setProveedor(proveedor);
			productoProveedor.setProducto(producto);
			productoProveedorRepository.save(productoProveedor);
			logger.info(productoProveedor.toString());
			
			DetallePedido detallePedido = new DetallePedido();
			detallePedido.setCantidad(20);
			detallePedido.setPedidos(pedidos);
			detallePedido.setProductoProveedor(productoProveedor);
			detallePedidoRepository.save(detallePedido);
			logger.info(detallePedido.toString());
			
			EstadoTrazabilidad estadoTrazabilidad = new EstadoTrazabilidad();
			estadoTrazabilidad.setDescripcion("ENVIADO");
			estadoTrazabilidadRepository.save(estadoTrazabilidad);
			logger.info(estadoTrazabilidad.toString());
			
			Trazabilidad trazabilidad = new Trazabilidad();
			trazabilidad.setEstadoTrazabilidad(estadoTrazabilidad);
			trazabilidad.setPedidos(pedidos);
			trazabilidad.setCodigoTrazabilidad("123123");
			trazabilidad.setFechaEnvio(LocalDate.now());
			trazabilidad.setFechaEstimadaEnvio(LocalDate.now());
			trazabilidad.setFechaFinPreparacion(LocalDate.now());
			trazabilidad.setFechaInicioPreparacion(LocalDate.now());
			trazabilidadRepository.save(trazabilidad);			
			logger.info(trazabilidad.toString());
		};
	}
	
	@Bean
	public CommandLineRunner createBodega() {
		return (args) -> {
			
//			Bodega bodega1 = new Bodega();	
//			bodega1.setDescripcion("Mi Bodega original 1");
//			bodegaRepository.save(bodega1);
//			logger.info(bodega1.toString());
//			
//			ProductosBodega productosBodega = new ProductosBodega();
//			productosBodega.setBodega(bodega1);
//			productosBodegaRepository.save(productosBodega);
//			logger.info(productosBodega.toString());
			
		};
	}
	
	@Bean
	public CommandLineRunner findAllBodegas() {
		return (args) -> {
			Iterator<Bodega> iteratorBodega = bodegaRepository.findAll().iterator();
			
			while(iteratorBodega.hasNext()) {
				logger.info(iteratorBodega.next().toString());
			}
			
		};
	}
	
	@Bean
	public CommandLineRunner createUsers() {
		return (args) -> {
			Usuario usuarioAdmin = new Usuario();
			Rol rol = new Rol();
			
			rol.setDescripcion("ADMIN");
			
			rolRepository.save(rol);
			
			usuarioAdmin.setNombre("Pedro Gutierrez");
			usuarioAdmin.setEmail("pedro@gmail.com");
			usuarioAdmin.setPassword(passwordEncoder.encode("1234"));
			usuarioAdmin.setRol(rol);
			usuarioRepository.save(usuarioAdmin);
		};
	}
	
	@Bean
	public CommandLineRunner findAllUsuarios() {
		return (args) -> {
			
			Iterator<Usuario> itUsuarios = usuarioRepository.findAll().iterator();
			
			while(itUsuarios.hasNext()) {
				System.out.println("All: " + itUsuarios.next().toString());
			}
		};
	}
	
	@Bean
	public CommandLineRunner findByUserName() {
		return (args) -> {
			
			List<Usuario> listaUsuarios = usuarioRepository.findByEmail("pedro@gmail.com");
			
			for (Usuario usuario : listaUsuarios) {
				System.out.println("Usuario por email: " + usuario.toString());
			}
		};
	}
	
}


