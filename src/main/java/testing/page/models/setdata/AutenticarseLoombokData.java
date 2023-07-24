package testing.page.models.setdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class AutenticarseLoombokData {
    String usuario;
    String contrasena;

    public static List<AutenticarseLoombokData> setData(DataTable dataTable) {
        List<AutenticarseLoombokData> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, AutenticarseLoombokData.class));
        }
        return dates;
    }
}
