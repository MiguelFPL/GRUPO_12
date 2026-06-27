package com.example.appmobile_menu;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MasDatosContacto extends AppCompatActivity {

    private String nombre, apellido, telefono, tipoTelefono, email, tipoEmail, direccion, fechaNacimiento;
    private RadioGroup radioGroupEstudios;
    private CheckBox checkDeporte, checkMusica, checkArte, checkTecnologia;
    private Switch switchInfo;
    private Button botonGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mas_datos_contacto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
        });

        Intent intentRecibido = getIntent();
        nombre = intentRecibido.getStringExtra("nombre");
        apellido = intentRecibido.getStringExtra("apellido");
        telefono = intentRecibido.getStringExtra("telefono");
        tipoTelefono = intentRecibido.getStringExtra("tipoTelefono");
        email = intentRecibido.getStringExtra("email");
        tipoEmail = intentRecibido.getStringExtra("tipoEmail");
        direccion = intentRecibido.getStringExtra("direccion");
        fechaNacimiento = intentRecibido.getStringExtra("fechaNacimiento");

        radioGroupEstudios = findViewById(R.id.radioGroupEstudios);
        checkDeporte = findViewById(R.id.checkDeporte);
        checkMusica = findViewById(R.id.checkMusica);
        checkArte = findViewById(R.id.checkArte);
        checkTecnologia = findViewById(R.id.checkTecnologia);
        switchInfo = findViewById(R.id.switchInfo);
        TextView textEstadoSwitch = findViewById(R.id.textEstadoSwitch);

        switchInfo.setOnCheckedChangeListener((buttonView, isChecked) -> {
            textEstadoSwitch.setText(isChecked ? "Sí" : "No");
        });
        botonGuardar = findViewById(R.id.botonGuardar);

        botonGuardar.setOnClickListener(v -> {
            if (validaciones()) {
                int idSeleccionado = radioGroupEstudios.getCheckedRadioButtonId();
                RadioButton radioElegido = findViewById(idSeleccionado);
                String nivelEstudios = radioElegido.getText().toString();

                boolean deporte = checkDeporte.isChecked();
                boolean musica = checkMusica.isChecked();
                boolean arte = checkArte.isChecked();
                boolean tecnologia = checkTecnologia.isChecked();

                boolean deseaInfo = switchInfo.isChecked();

            }
        });
    }

    public boolean validaciones() {
        boolean estado = true;

        // RadioGroup: getCheckedRadioButtonId() devuelve -1 si no hay ninguno seleccionado
        if (radioGroupEstudios.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Seleccioná un nivel de estudios", Toast.LENGTH_SHORT).show();
            estado = false;
        }

        // Checkboxes: al menos uno marcado
        if (!checkDeporte.isChecked() && !checkMusica.isChecked()
                && !checkArte.isChecked() && !checkTecnologia.isChecked()) {
            Toast.makeText(this, "Seleccioná al menos un interés", Toast.LENGTH_SHORT).show();
            estado = false;
        }

        return estado;
    }
}