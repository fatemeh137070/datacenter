//package com.datacenter.service.dataCenterService;
////
//
//
//import com.datacenter.da.entity.DataCenter;
//
//@ExtendWith(MockitoExtension.class)
//class DataCenterServiceTest {
//
//    @InjectMocks
//    private DataCenterServiceImpl service;
//
//    @Mock
//    private DataCenterRepository repository;
//
//    @Test
//    void shouldCreateDataCenter() {
//        DataCenter dc = new DataCenter();
//        dc.setName("Test DC");
//
//        when(repository.save(dc)).thenReturn(dc);
//
//        DataCenter saved = service.save(dc);
//
//        assertNotNull(saved);
//        assertEquals("Test DC", saved.getName());
//        verify(repository, times(1)).save(dc);
//    }
//
//    @Test
//    void shouldFindById() {
//        DataCenter dc = new DataCenter();
//        dc.setId(1L);
//        dc.setName("DC1");
//
//        when(repository.findById(1L)).thenReturn(Optional.of(dc));
//
//        Optional<DataCenter> found = service.findById(1L);
//
//        assertTrue(found.isPresent());
//        assertEquals("DC1", found.get().getName());
//    }
//}