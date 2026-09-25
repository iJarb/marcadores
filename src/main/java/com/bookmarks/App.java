package com.bookmarks;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import java.awt.Desktop;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    private static final Path BOOKMARKS_FILE = Paths.get("bookmarks.json");

    public static void main(String[] args) {
        int port = 8080;
        
        inicializarArchivoJson();

        // CORREGIDO: Añadimos la configuración para ignorar barras diagonales finales (Trailing Slashes)
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public", Location.CLASSPATH);
            config.router.treatMultipleSlashesAsSingleSlash = true; // Evita problemas con rutas mal formadas
        }).start(port);

        // Definimos los endpoints tanto con barra como sin barra para asegurar el tiro
        
        // GET - Obtener marcadores
        app.get("/api/bookmarks", ctx -> responderConJson(ctx));
        app.get("/api/bookmarks/", ctx -> responderConJson(ctx));

        // POST - Guardar marcadores
        app.post("/api/bookmarks", ctx -> guardarJson(ctx));
        app.post("/api/bookmarks/", ctx -> guardarJson(ctx));

        System.out.println("====== Servidor Hyperclay Portable Activo ======");
        System.out.println("URL: http://localhost:" + port);
        System.out.println("================================================");

        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("http://localhost:" + port));
            }
        } catch (Exception e) {
            // Modo headless
        }
    }

    private static void responderConJson(io.javalin.http.Context ctx) throws Exception {
        String jsonContent = Files.readString(BOOKMARKS_FILE);
        ctx.contentType("application/json");
        ctx.result(jsonContent);
    }

    private static void guardarJson(io.javalin.http.Context ctx) throws Exception {
        String nuevoJson = ctx.body();
        Files.writeString(BOOKMARKS_FILE, nuevoJson);
        ctx.status(200).result("{\"status\":\"success\"}");
    }

    private static void inicializarArchivoJson() {
        try {
            if (!Files.exists(BOOKMARKS_FILE)) {
                Files.writeString(BOOKMARKS_FILE, "[]");
            }
        } catch (Exception e) {
            System.err.println("Error al inicializar el archivo bookmarks.json: " + e.getMessage());
        }
    }
}
