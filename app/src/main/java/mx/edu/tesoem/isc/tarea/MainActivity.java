package mx.edu.tesoem.isc.tarea;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mx.edu.tesoem.isc.tarea.Modelo.Datos;

public class MainActivity extends AppCompatActivity {
    TextView nombre, correo, edad, nombrePersist, correoPersist, edadPersist;
    Button mostrar, guardar;
    Datos datos;
    String nombre1 = "", correo1="", edad1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datos = new ViewModelProvider(this).get(Datos.class);

        nombre = findViewById(R.id.etxtNombre);
        correo = findViewById(R.id.etxtCorreo);
        edad = findViewById(R.id.etxtEdad);
        nombrePersist = findViewById(R.id.etxtNombrePersist);
        correoPersist = findViewById(R.id.etxtCorreoPersist);
        edadPersist = findViewById(R.id.etxtEdadPersist);
        mostrar = findViewById(R.id.btnMostrar);
        guardar = findViewById(R.id.btnGuardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datos.setNombre(nombrePersist.getText().toString());
                datos.setEdad(parseInt(edadPersist.getText().toString()));
                datos.setCorreo(correoPersist.getText().toString());
                nombre1 = nombrePersist.getText().toString();
                edad1 = edadPersist.getText().toString();
                correo1 = correoPersist.getText().toString();
                nombrePersist.setText("");
                edadPersist.setText("");
                correoPersist.setText("");
            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre.setText(nombre1);
                edad.setText(edad1);
                correo.setText(correo1);
                nombrePersist.setText(datos.getNombre());
                edadPersist.setText(valueOf(datos.getEdad()).toString());
                correoPersist.setText(datos.getCorreo());
            }
        });
    }
}