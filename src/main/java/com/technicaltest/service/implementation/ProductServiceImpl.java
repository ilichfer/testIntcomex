package com.technicaltest.service.implementation;

import com.technicaltest.dto.ProductDTO;
import com.technicaltest.mappers.ProductMapper;
import com.technicaltest.model.Categories;
import com.technicaltest.model.Products;
import com.technicaltest.model.Suppliers;
import com.technicaltest.repository.CategoriesRepository;
import com.technicaltest.repository.ProductRepository;
import com.technicaltest.repository.SupplierRepository;
import com.technicaltest.service.IProductService;
import com.technicaltest.util.PagedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final CategoriesRepository categoriesRepository;
    private final ProductMapper productMapper;

    private static final List<String> PRODUCT_NAMES = List.of("Laptop", "Smartphone", "Tablet", "Monitor", "Teclado", "Mouse", "Auriculares", "Impresora", "Cámara", "Microfono");



    public ProductServiceImpl(ProductRepository productRepository, SupplierRepository supplierRepository, CategoriesRepository categoriesRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.categoriesRepository = categoriesRepository;
        this.productMapper = productMapper;
    }

    @Override
    public void saveRamdom() {
        List<Suppliers> listSuppliers = getsuppliersBD();
        List<Categories> listCategory = getCategoriesBD();
        int quantity= (int) (Math.random() * 10) + 1;

        List<Products> products = IntStream.rangeClosed(1, 100_000)
                .mapToObj(i -> new Products(
                        null,
                        PRODUCT_NAMES.get(ThreadLocalRandom.current().nextInt(PRODUCT_NAMES.size())),
                        getRandomSupplier(listSuppliers),
                        getRandomCategories(listCategory),
                        quantity,
                        10000,
                        quantity,
                        1,
                        1,
                       false
                ))
                .collect(Collectors.toList());



        productRepository.saveAll( products);
    }

    @Override
    public void save(ProductDTO Product) {

    }

    @Override
    public PagedResponse findPage(Pageable pageable) {
        Page<Products> productos =  productRepository.findAll(pageable);
        return new PagedResponse<>(productos.getContent(),productos.getTotalPages(),productos.getTotalElements(),productos.getNumber(),productos.getSize());
    }

    @Override
    public List<ProductDTO> findAll() {
        //return List.of();
        List<Products> productos =  productRepository.findAll();
        return productMapper.listEntitytoProductDTO(productos);
    }

    @Override
    public ProductDTO findById(Integer id) throws Exception {
       return productMapper.EntitytoProductDTO(productRepository.findById(id).orElseThrow(() -> new Exception()));
    }

    private  List<Categories> createCategories() {
        List<Categories> categoriesList = List.of(
                new Categories(null, "Electrónica", "Dispositivos electrónicos y gadgets",""),
                new Categories(null, "Informática", "Computadoras y accesorios",""),
                new Categories(null, "Oficina", "Suministros y equipos de oficina",""),
                new Categories(null, "Hogar", "Productos para el hogar",""),
                new Categories(null, "Jardín", "Herramientas y accesorios de jardinería",""),
                new Categories(null, "Deportes", "Artículos deportivos y fitness",""),
                new Categories(null, "Ropa", "Vestimenta y accesorios",""),
                new Categories(null, "Juguetes", "Juguetes y juegos para niños",""),
                new Categories(null, "Automotriz", "Accesorios y repuestos para autos",""),
                new Categories(null, "Salud", "Productos de salud y cuidado personal","")
        );
        return categoriesList;
    }

        private  List<Suppliers> createSuppliers(){
        // Implementación para crear una lista de proveedores
        List<Suppliers> suppliersList = List.of(
                new Suppliers(
                        1, // supplierID
                        "Tech Solutions", // companyName
                        "Gerente de Compras", // contactTitle
                        "Calle Falsa 123", // address
                        "Ciudad Ejemplo", // city
                        "Región Central", // region
                        "12345", // postalCode
                        "País Ejemplo", // country
                        "+34 123 456 789", // phone
                        "+34 987 654 321", // fax
                        "www.techsolutions.com" // homePage
                ),
                 new Suppliers(
                        null,
                        "InnovaTech",
                        "Director de Ventas",
                        "Avenida Siempre Viva 742",
                        "Springfield",
                        "Región Norte",
                        "54321",
                        "País Prueba",
                        "+34 222 333 444",
                        "+34 555 666 777",
                        "www.innovatech.com"
                ), new Suppliers(
                null,
                "Distribuciones Globales",
                "Jefe de Compras",
                "Calle Principal 456",
                "Metropolis",
                "Región Sur",
                "67890",
                "País Demo",
                "+34 888 999 000",
                "+34 111 222 333",
                "www.distribucionesglobales.com"
        ),

        new Suppliers(
                null,
                "Soluciones Empresariales",
                "Gerente General",
                "Boulevard Central 789",
                "Ciudad Central",
                "Región Este",
                "11223",
                "País Ejemplo",
                "+34 444 555 666",
                "+34 777 888 999",
                "www.solucionesempresariales.com"
        )

        );


        return supplierRepository.saveAll(suppliersList);
    }

    // Cambia este método:
    private Suppliers getRandomSupplier(List<Suppliers> suppliers) {
        Random random = new Random();
        int randomIndex = random.nextInt(suppliers.size());
        return suppliers.get(randomIndex);
    }

    private List<Categories> getCategoriesBD() {
        List<Categories> listCategories;
        listCategories = categoriesRepository.findAll();
        if (listCategories.isEmpty())
            throw new RuntimeException("No existen categorías en la base de datos, por favor, crea algunas.");
        return categoriesRepository.findAll();
    }

    private List<Suppliers> getsuppliersBD() {
        List<Suppliers> listSuppliers;
        listSuppliers= supplierRepository.findAll();
        if (listSuppliers.isEmpty())
            listSuppliers = createSuppliers();

        return listSuppliers;
    }


        private Categories getRandomCategories(List<Categories> categoriesList) {
        List<Categories> categoriesReturn = new ArrayList<>();

        Random random = new Random();
        int randomIndex = random.nextInt(categoriesList.size());
        return categoriesList.get(randomIndex);

    }
}
