package com.gachaapi.Service.interfaces;

import com.gachaapi.Entity.Element;

import java.util.List;

public interface HomeService {

    List<Element> getPlayerDetails(String nick);
}
