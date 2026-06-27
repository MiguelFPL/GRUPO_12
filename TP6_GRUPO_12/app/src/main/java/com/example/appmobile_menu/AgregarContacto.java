package com.example.appmobile_menu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.DatePickerDialog;
import java.util.Calendar;
import android.widget.Button;


public class AgregarContacto extends AppCompatActivity {

    private EditText etNombre;
    private EditText etApellido;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDireccion;
    private EditText etFecha;
    private Button btnContinuar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_contacto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etNombre = findViewById(R.id.editTextNombre);
        etApellido = findViewById(R.id.editTextApellido);
        etTelefono = findViewById(R.id.editTextTelefono);
        etEmail = findViewById(R.id.editTextEmail);
        etDireccion = findViewById(R.id.editTextDireccion);
        etFecha = findViewById(R.id.editTextFecha);


        etFecha.setOnClickListener(v -> {
            Calendar calendario = Calendar.getInstance();
            int anioActual = calendario.get(Calendar.YEAR);
            int mesActual = calendario.get(Calendar.MONTH);
            int diaActual = calendario.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePicker = new DatePickerDialog(
                    AgregarContacto.this,
                    (view, anio, mes, dia) -> {
                        String fechaFormateada = String.format("%02d/%02d/%04d", dia, mes + 1, anio);
                        etFecha.setText(fechaFormateada);
                    },
                    anioActual, mesActual, diaActual);

            // Evita que se pueda elegir una fecha futura como fecha de nacimiento
            datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());

            datePicker.show();
        });

        Spinner spinnerTelefono = findViewById(R.id.spinnerTelefono);
        Spinner spinnerEmail = findViewById(R.id.spinnerEmail);

        ArrayAdapter<CharSequence> adapterTelefono = ArrayAdapter.createFromResource(
                this,R.array.tipos_contacto, android.R.layout.simple_spinner_item);
                adapterTelefono.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerTelefono.setAdapter(adapterTelefono);
        ArrayAdapter<CharSequence> adapterEmail = ArrayAdapter.createFromResource(
                this,R.array.tipos_contacto, android.R.layout.simple_spinner_item);
                adapterEmail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerEmail.setAdapter(adapterEmail);

        btnContinuar = findViewById(R.id.botonContinuar);

        btnContinuar.setOnClickListener(v -> {
            if (validaciones()) {
                Intent intent = new Intent(AgregarContacto.this, MasDatosContacto.class);
                intent.putExtra("nombre", etNombre.getText().toString());
                intent.putExtra("apellido", etApellido.getText().toString());
                intent.putExtra("telefono", etTelefono.getText().toString());
                intent.putExtra("tipoTelefono", spinnerTelefono.getSelectedItem().toString());
                intent.putExtra("email", etEmail.getText().toString());
                intent.putExtra("tipoEmail", spinnerEmail.getSelectedItem().toString());
                intent.putExtra("direccion", etDireccion.getText().toString());
                intent.putExtra("fechaNacimiento", etFecha.getText().toString());
                startActivity(intent);
            }
        });
    }

    public boolean validaciones()
    {
        boolean estado = true;
        etNombre.setError(null);
        etApellido.setError(null);
        etTelefono.setError(null);
        etDireccion.setError(null);
        etEmail.setError(null);
        etFecha.setError(null);

        if(etNombre.getText().toString().isEmpty()){
            etNombre.setError("Campo requerido");
            estado = false;
        }
        else if (etNombre.getText().toString().length()< 3){
            etNombre.setError("Minimo 3 caracteres");
            estado = false;
        }
        else if (!etNombre.getText().toString().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            etNombre.setError("Solo se permiten letras");
            estado = false;
        }

        if(etApellido.getText().toString().isEmpty()){
            etApellido.setError("Campo requerido");
            estado = false;
        }
        else if (!etApellido.getText().toString().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            etApellido.setError("Solo se permiten letras");
            estado = false;
        }

        if(etTelefono.getText().toString().isEmpty()) {
            etTelefono.setError("Campo requerido");
            estado = false;
        }
        else if (!etTelefono.getText().toString().matches("^[0-9-]+$")) {
            etTelefono.setError("Solo números y guiones");
            estado = false;
        }

        if(etDireccion.getText().toString().isEmpty()){
            etDireccion.setError("Campo requerido");
            estado = false;
        }

        if(etEmail.getText().toString().isEmpty()){
            etEmail.setError("Campo requerido");
            estado = false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()){
            etEmail.setError("Correo Invalido");
            estado=false;
        }
        if(etFecha.getText().toString().isEmpty()){
            etFecha.setError("Campo requerido");
            estado = false;
        }
        return estado;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.opcion1){
            Intent intent = new Intent(this, AgregarContacto.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.opcion2){
            Intent intent = new Intent(this, ListadoContactos.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}