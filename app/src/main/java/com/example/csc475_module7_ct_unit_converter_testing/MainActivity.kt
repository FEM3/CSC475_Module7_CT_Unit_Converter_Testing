package com.example.csc475_module7_ct_unit_converter_testing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.csc475_module7_ct_unit_converter_testing.ui.theme.CSC475_Module7_CT_Unit_Converter_TestingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CSC475_Module7_CT_Unit_Converter_TestingTheme {
                ConverterAppContent()
            }
        }
    }
}

@Composable
fun ConverterAppContent(viewModel: TempConversionViewModel = hiltViewModel()) {
    val input by viewModel.input.collectAsState()
    val result by viewModel.result.collectAsState()

    Module7ConverterScreen(
        tempInput = input,
        tempResult = result,
        onTempChange = { viewModel.onInputChanged(it) },
        onCToF = { viewModel.convertCelsiusToFahrenheit() },
        onFToC = { viewModel.convertFahrenheitToCelsius() }
    )
}

@Composable
fun Module7ConverterScreen(
    tempInput : String,
    tempResult: String,
    onTempChange: (String) -> Unit,
    onCToF: () -> Unit,
    onFToC: () -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            OutlinedTextField(
                value = tempInput,
                onValueChange = onTempChange,
                label = { Text("Value") }
            )
            Button(onClick = onCToF) {
                Text("C to F")
            }
            Button(onClick = onFToC) {
                Text("F to C")
            }
            Text("Result: $tempResult")
        }
    }
}