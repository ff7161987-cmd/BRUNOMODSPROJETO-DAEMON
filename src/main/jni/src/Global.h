#ifndef ANDROID_MOD_MENU_GLOBAL_H
#define ANDROID_MOD_MENU_GLOBAL_H

struct {
    
   /*---------- TRANSFORM POSITION -----------*/
    
    uintptr_t HeadTF = 0x1e8; // protected Transform JoqBDUR; 2
    uintptr_t HipsTF = 0x1ec; // 3
    uintptr_t ToeTF = 0x1fc;  // 7
    uintptr_t OmbroD = 0x210; // 14
    uintptr_t OmbroE = 0x214; // 15
    uintptr_t PernaD = 0x204; // 9
    uintptr_t PernaE = 0x208; // 10
    uintptr_t BracoD = 0x20c; // 13
    uintptr_t BracoE = 0x1e4; // 1

    
    /*------------ TRANSFORM DIRITORIO ----------*/
    
    uintptr_t MainCameraTransform = 0x6c;
    uintptr_t Dictionary = 0x44; //internal class `ZtmgF(){}
    uintptr_t Transform_INTERNAL_GetPosition = 0x2c345b8;
    uintptr_t Transform_INTERNAL_SetPosition = 0x2c34658;

    /*---------- Linha Granada -----------*/
    
    uintptr_t LineRenderer_Set_PositionCount = 0x2a91ab4;//1.60 certa
    uintptr_t LineRenderer_SetPosition = 0x2a91b60;//1.60 certa
    uintptr_t GrenadeLine_DrawLine = 0xC78eC8;//1.60 certa
    
    /* ---------- Obter -----------*/
    
    uintptr_t get_IsFiring = 0x6f9d758; // public bool IsFiring()
    uintptr_t get_IsSighting = 0x6fa6cbc; // public bool get_IsSighting()
    uintptr_t get_isLocalTeam = 0x8c2d18; // Nao encontrado no dump, mantido o antigo
    uintptr_t get_isVisible = 0x6fb5b98; // public override bool IsVisible()
    uintptr_t get_MaxHP = 0x70168c8; // public int get_MaxHP()
    uintptr_t get_IsDieing = 0x6f9b2ec; // public bool get_IsDieing()
    uintptr_t get_IsCrouching = 0x6f96974; // public bool IsCrouching()
    uintptr_t get_NickName = 0x6fad590; // public string get_NickName()
    uintptr_t get_isAlive = 0x752fa28; // public bool IsAlive()
    uintptr_t get_MyFollowCamera = 0x6fb00b8; // public FollowCamera get_MyFollowCamera()
    uintptr_t get_CurHP = 0x70167d0; // public int get_CurHP()
        
    /*---------- Setar -----------*/
    
    uintptr_t set_aim = 0x6fb20c0; // public void SetAimRotation(Quaternion, bool)
    uintptr_t get_imo = 0x8b554c; // GetActiveWeapon() - Mantido antigo
    uintptr_t set_esp = 0x1585250; // Mantido antigo
    uintptr_t set_esp1 = 0x17163e4; // Mantido antigo
        
    /*---------- Popup -----------*/
    
    uintptr_t ShowAssistantText = 0x774fb24; // public void ShowAssistantText
    uintptr_t ShowDynamicPopupMessage = 0x771a1f0;
    uintptr_t ShowPopupMessage = 0x771a338;
    uintptr_t U3DStr = 0x9e573fc; // private string CreateString(sbyte* value, int, int)
    uintptr_t CurrentUIScene = 0x72903bc; // public static UICOWBaseScene CurrentUIScene()
    uintptr_t String_Concat = 0x9e44870; // public static string Concat(string str0, string str1)
        
    /*------------ Player ----------*/
    
    
    uintptr_t Component_GetTransform = 0x6a82280; // public Transform get_transform()
    uintptr_t GetForward = 0xa704a8c; // public Vector3 get_forward()
    uintptr_t GetAttackableCenterWS = 0x6fac8f4;
    uintptr_t GetLocalPlayer = 0x87f34c0; // private Player GetLocalPlayer()
    uintptr_t Current_Local_Player = 0x7292f30; // public static Player CurrentLocalPlayer()
    uintptr_t GetLocalPlayerOrObServer = 0x9Db890; // Mantido antigo
    uintptr_t Player_Index = 0xa24fc0; // Mantido antigo
    
    /*------------ Outros -----------*/
    
    uintptr_t Curent_Match = 0x9d9ea4; // Mantido antigo
    uintptr_t Camera_main = 0xa6af630; // public static Camera get_main()
    uintptr_t WorldToScreenPoint = 0xa6af2b4; // public Vector3 WorldToScreenPoint(Vector3 position)
    uintptr_t GetIsDead = 0x7b97b80; // public bool get_IsDead()
    uintptr_t GetWeaponType = 0x904328; // Mantido antigo
    uintptr_t get_Chars = 0x2e3e380; // Mantido antigo
    
    uintptr_t get_height = 0xa6bcd6c; // public static int get_height()
    uintptr_t get_width = 0xa6bcd44; // public static int get_width()
    
    //Alerta
    uintptr_t IsClientBot = 0x438; // public bool IsClientBot;
    uintptr_t get_Firing = 0x6f9d758; 
    uintptr_t get_Sighting = 0x6fa6cbc; 
    uintptr_t get_Driver = 0x8ba60c; 
    uintptr_t get_Kitmedico = 0x8b8f10; 
    uintptr_t get_SkySurfing = 0x8bb5dc; 
    uintptr_t get_Parachuting = 0x8bb150; 
    uintptr_t get_IsCreep = 0x8eca54; 
    uintptr_t get_IsSwimming = 0x13F8380; 
    uintptr_t get_IsRescureing = 0x8b96a0; 
    uintptr_t get_Crouching =  0x6f96974; 
    uintptr_t get_IsGrenadeStart = 0x8b8f58; 
    uintptr_t get_IsThrowingKnifeStart = 0x8b90b4; 
    uintptr_t get_IsWearingCamouflage = 0x8bb8ec; 
    
    
} Global;


#endif
