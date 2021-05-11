package Wrappers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileReader {
    public  static  String jsonPath = "D:\\iti\\jsonfile.json";
    JSONObject jsonObject;
    public JsonFileReader(String file)
    {
        parseJson(file);
    }

    public void parseJson(String file)
    {
        String jsonData = readFile(file);
        try {
            jsonObject = new JSONObject(jsonData);
        }
        catch (Exception ex)
        {
            ex.getMessage();
        }
    }

    public String readFile(String file)
    {
        String result="";
        try {
        	//reader
            BufferedReader bufferedReader = new BufferedReader( new FileReader(file));
            //ba7welo le string 3ashan el library de 3ayza keda
            StringBuilder stringBuilder = new StringBuilder();
            //beread line by line
            String Line = bufferedReader.readLine();

            while (Line!=null)
            {
            	//lo kan += yb2a keda bylza2o fe b3d
                stringBuilder.append(Line);
                Line= bufferedReader.readLine();
            }
            //b3d ma y2ra be while
            result = stringBuilder.toString();
            return result;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
 //bab3et esm el node
    public String getValueOfNode(String parent){

        String [] tree= parent.split("/");
        if(tree.length==1)
        {
            try {
				return jsonObject.getString(tree[0]);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return  null;
			}
        }
        int i = 1;
        JSONObject parentNode= null;
        try
        {
            parentNode = (JSONObject) jsonObject.get(tree[0]);
            while (i < tree.length-1){
                parentNode = (JSONObject)parentNode.get(tree[i]);
                i++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return  null;
        }
        try {
			return parentNode.getString(tree[i]);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  null;
		}
    }

    public List<String> getValueOf(String parent, String child)
    {
        Object obj=null;
        JSONArray value=null;
        String singleValue=null;
        boolean isArray= false;

        if(child==null)
        {
            try
            {
                obj= jsonObject.get(parent);
                if(obj instanceof JSONArray)
                {
                    value= new JSONArray(jsonObject.getJSONArray(parent).toString());
                    isArray= true;
                }
                else
                {
                    singleValue=jsonObject.getString(parent);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }

        else
        {
            JSONObject parentNode;
            try
            {
                parentNode= (JSONObject) jsonObject.get(parent);
                obj= parentNode.get(child);
                if(obj instanceof JSONArray)
                {
                    value= new JSONArray(parentNode.getJSONArray(child).toString());
                    isArray= true;
                }

                else
                {
                    singleValue=parentNode.getString(child);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }

        List<String> list = new ArrayList<>();
        if(isArray)
        {
            for(int i=0; i< value.length(); i++)
            {
                try
                {
                    list.add(value.getString(i));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
        }

        else
        {
            list.add(singleValue);
        }

        return list;
    }
}
