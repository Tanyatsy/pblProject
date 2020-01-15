package com.pbl.services.serviceImpl;

import com.pbl.models.ConnectiveTable;
import com.pbl.respositories.ConectiveTableRepository;
import com.pbl.services.ConectiveTableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ConnectiveTableImpl implements ConectiveTableService {

    private final ConectiveTableRepository conectiveTableRepository;
    @Override
    public List<ConnectiveTable> findAllInfo() {
        return conectiveTableRepository.findAll();
    }
}
