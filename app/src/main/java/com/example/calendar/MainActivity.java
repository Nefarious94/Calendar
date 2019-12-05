package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button fecha, bhora;
    TextView textof, textoh;
    int año, mes, dia, hora, minuto, segundo;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fecha = findViewById(R.id.Fecha);
        bhora = findViewById(R.id.Hora);
        textof = findViewById(R.id.TextoF);
        textoh = findViewById(R.id.TextoH);

        fecha.setOnClickListener(this);
        bhora.setOnClickListener(this);
    }

    public void onClick(View v){
        if (v==fecha){
            final Calendar c = Calendar.getInstance();
            año = c.get(Calendar.YEAR);
            mes = c.get(Calendar.MONTH);
            dia = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog pickfecha= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                   textof.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                   toast.makeText(textof.getContext(), dayOfMonth+"/"+(month+1)+"/"+year, toast.LENGTH_LONG).show();
                }
            }
            ,dia,mes,año);
            pickfecha.show();
        }if (v==bhora){
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minuto = c.get(Calendar.MINUTE);
            segundo = c.get(Calendar.SECOND);

            TimePickerDialog pickhora= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    textoh.setText(hourOfDay+":"+minute);
                    toast.makeText(textoh.getContext(), hourOfDay+":"+minute, toast.LENGTH_LONG).show();
                }
            }
                    ,hora,minuto,false);
            pickhora.show();
        }
    }
}
