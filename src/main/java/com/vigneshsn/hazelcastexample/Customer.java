package com.vigneshsn.hazelcastexample;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.io.IOException;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class Customer implements DataSerializable {
    private String id;
    private String name;

    @Override
    public void writeData(ObjectDataOutput objectDataOutput) throws IOException {
        objectDataOutput.writeUTF(id);
        objectDataOutput.writeUTF(name);
    }

    @Override
    public void readData(ObjectDataInput objectDataInput) throws IOException {
        id = objectDataInput.readUTF();
        name= objectDataInput.readUTF();
    }
}
