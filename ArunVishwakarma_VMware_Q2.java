package com.vmwaresolution
 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.*;

public class Shapes 
{
    Static List listOfOutput;
	@SuppressWarnings("unchecked")
    public static void main(String[] args) 
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("Input.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray shapesList = (JSONArray) obj;
            System.out.println(shapesList);
             
            //Iterate over shapes array
            shapesList.forEach( shape -> parseShapesObject( (JSONObject) shape ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

	//Calculatihg the output
	public static void parseShapesObject(JSONObject shape){

			JSONObject shapeObject = (JSONObject) s.get("type");
			String type = (String)shapeObject.get("type");
			if(type.equals("circle")){
				String radius = (String)shapeObject.get("radius");
				double output = Integer.parseInt(radius)*22/7;
				listOfOutput.add(output);
				
			}
			else if(type.equals("rectange")){
					String l= (String)shapeObject.get("l");
					String b= (String)shapeObject.get("b");
					int output = Integer.parseInt(l)*Integer.parseInt(b);
					listOfOutput.add(output);
					
			}
			else if(type.equals("square")){
				String side = (String)shapeObject.get(side);
				int output = (int)Math.pow(Integer.parseInt(side),2);
				listOfOutput.add(output);
			}				
	}
			
	public static void writeShapesObject(List listOfOutput){
		try (FileWriter file = new FileWriter("Output.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(listOfOutput.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
		
}
 