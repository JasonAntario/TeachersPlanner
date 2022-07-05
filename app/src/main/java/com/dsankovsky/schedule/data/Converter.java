package com.dsankovsky.schedule.data;

import java.util.Arrays;
import java.util.List;

public class Converter {

        @androidx.room.TypeConverter
        public String fromHobbies(List<String> hobbies) {
            return String.join(",", hobbies);
        }

    @androidx.room.TypeConverter
        public List<String> toHobbies(String data) {
            return Arrays.asList(data.split(","));
        }

    }
