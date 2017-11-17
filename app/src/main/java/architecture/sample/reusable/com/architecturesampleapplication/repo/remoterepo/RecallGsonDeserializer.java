package architecture.sample.reusable.com.architecturesampleapplication.repo.remoterepo;

/*
 * Created by 849501 on 11/15/2017.
 */

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import architecture.sample.reusable.com.architecturesampleapplication.repo.RecallRepoModel;

public class RecallGsonDeserializer implements JsonDeserializer<RecallRepoModel> {


    @Override
    public RecallRepoModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        // get the 'android' element from the complete json
        JsonElement androidElement = json.getAsJsonObject().get("android");

        // Deserialize it. You use a new instance of Gson to avoid infinite recursion
        // to this deserializer
        return new Gson().fromJson(androidElement, typeOfT);

    }
}
