package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.api.v1.model.VendorListDTO;
import guru.springfamework.services.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(description = "Vendor Controller")
@RestController
@RequestMapping(VendorController.BASE_URL)
public class VendorController {
    public static final String BASE_URL = "/api/v1/vendors";
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @ApiOperation(value = "List of all vendors")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getAllVendors(){
        return vendorService.getAllVendors();
    }

    @ApiOperation(value = "Find vendor by id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendorById(@PathVariable String id){
        return vendorService.getVendorById(Long.valueOf(id));
    }

    @ApiOperation(value = "Create new vendor")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO createNewVendor(@RequestBody VendorDTO VendorDTO){
        return vendorService.createNewVendor(VendorDTO);
    }

    @ApiOperation(value = "Update vendor's data")
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@PathVariable Long id, @RequestBody VendorDTO VendorDTO){
        return vendorService.saveVendor(id, VendorDTO);
    }

    /**
     * In oppisote to update method, changes only properties that were passed (not null)
     * @param id
     * @param VendorDTO
     * @return
     */
    @ApiOperation(value = "Partially update vendor's data")
    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor(@PathVariable Long id, @RequestBody VendorDTO VendorDTO){
        return vendorService.patchVendor(id, VendorDTO);
    }

    @ApiOperation(value = "Delete vendor`")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id){
        vendorService.deleteVendorById(id);
    }


    public static String getVendorUrl(Long id) {
        return VendorController.BASE_URL + "/" + id;
    }

}
