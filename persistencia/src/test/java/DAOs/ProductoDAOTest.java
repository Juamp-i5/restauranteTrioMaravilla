/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import entidades.Producto;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jp
 */
public class ProductoDAOTest {
    
    public ProductoDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of obtenerProducto method, of class ProductoDAO.
     */
    @Test
    public void testObtenerProducto() throws Exception {
        System.out.println("obtenerProducto");
        Long idProducto = null;
        ProductoDAO instance = new ProductoDAO();
        Producto expResult = null;
        Producto result = instance.obtenerProducto(idProducto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerProductos method, of class ProductoDAO.
     */
    @Test
    public void testObtenerProductos() throws Exception {
        System.out.println("obtenerProductos");
        ProductoDAO instance = new ProductoDAO();
        List<Producto> expResult = null;
        List<Producto> result = instance.obtenerProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerProductosDisponibles method, of class ProductoDAO.
     */
    @Test
    public void testObtenerProductosDisponibles() throws Exception {
        System.out.println("obtenerProductosDisponibles");
        ProductoDAO instance = new ProductoDAO();
        List<Producto> expResult = null;
        List<Producto> result = instance.obtenerProductosDisponibles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isProductoDisponible method, of class ProductoDAO.
     */
    @Test
    public void testIsProductoDisponible() throws Exception {
        System.out.println("isProductoDisponible");
        Long idProducto = null;
        ProductoDAO instance = new ProductoDAO();
        Boolean expResult = null;
        Boolean result = instance.isProductoDisponible(idProducto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of persistirProducto method, of class ProductoDAO.
     */
    @Test
    public void testPersistirProducto() throws Exception {
        System.out.println("persistirProducto");
        Producto producto = null;
        ProductoDAO instance = new ProductoDAO();
        Producto expResult = null;
        Producto result = instance.persistirProducto(producto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
