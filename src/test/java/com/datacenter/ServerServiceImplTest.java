package com.datacenter;

import com.datacenter.da.entity.Server;
import com.datacenter.da.repository.ServerRepository;
import com.datacenter.dto.ServerDto;
import com.datacenter.mapper.ServerMapper;
import com.datacenter.service.serverService.ServerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServerServiceImplTest {

    @Mock
    private ServerRepository serverRepository;

    @Mock
    private ServerMapper serverMapper;

    @InjectMocks
    private ServerServiceImpl serverService;

    @Test
    void testSaveServer() {
        ServerDto dto = new ServerDto();
        dto.setId(1L);
        dto.setModel("Server-1U");
        // مقداردهی سایر فیلدهای dto در صورت نیاز

        Server entity = new Server();
        entity.setId(1L);
        entity.setModel("Server-1U");
        // مقداردهی سایر فیلدهای entity در صورت نیاز

        when(serverMapper.toEntity(any(ServerDto.class))).thenReturn(entity);
        when(serverRepository.save(any(Server.class))).thenReturn(entity);
        when(serverMapper.toDto(any(Server.class))).thenReturn(dto);

        ServerDto result = serverService.save(dto);

        System.out.println("Server Model: " + result.getModel());

        assertEquals("Server-1U", result.getModel());
        verify(serverRepository, times(1)).save(any(Server.class));
    }
}
