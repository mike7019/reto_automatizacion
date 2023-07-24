package testing.page.models.setdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class AgregarAlCarritoLoombokData {

    String nombreProducto;
    String nombre;
    String apellido;
    String zip;

    public static List<AgregarAlCarritoLoombokData> setData(DataTable dataTable) {
        List<AgregarAlCarritoLoombokData> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, AgregarAlCarritoLoombokData.class));
        }
        return dates;
    }
}
