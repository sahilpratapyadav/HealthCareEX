$(document).ready(function(){
    //1.hide error section
    $("#specCodeError").hide();
    $("#specNameError").hide();
    $("#specNoteError").hide();

    //2. define error varIABLE 
    var specCodeError =false;
    var specNameError =false;
    var specNoteError = false;

    //3 validate function

    function validate_specCode(){
        var val=$("#specCode").val();
        var exp = /^[A-Z]{4,10}$/;
        if(val==''){
            $("#specCodeError").show();
            $("#specCodeError").html("<b>Code</b> can not be empty");
            $("#specCodeError").css('color','red');
            specCodeError =false;

        }else if(!exp.test(val)){
            $("#specCodeError").show();
            $("#specCodeError").html("<b>Code</b> must be 4-12 chars only");
            $("#specCodeError").css('color','red');
            specCodeError =false;

        }else{
            var id=0; //for register
            if(("#id").val()!=undefined){
                //edit page
                specCodeError=true;
                id =$("#id").val();

            }
            $ajax({
                url:'checkCode',
                data:{"code":val,"id":id},
                success:function(resTxt){
                    if(resTxt!=''){
                        $("#specCodeError").show();
                        $("#specCodeError").html(resTxt);
                        $("#specCodeError").css('color','red');
                        specCodeError=false;
                    }else{
                        $("specCodeError").hide();
                        specCodeError=true;
                    }
                    
                }
            });
        }
        return specCodeError;
    }
    
})