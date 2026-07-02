#include <iostream>
#include "Includes/Utils.h"
#include "Unity/Chams.h"
#include "DHook/dhook.h"
#include "Hook.h"
#include "Global.h"
#include "Includes/Logger.h"
#include "Includes/obfuscator.hpp"
#include "Unity/ESP.h"
#include "Unity/StructsCommon.h"
#include "BrunoModsEsp/Rect.h"
#include "BrunoModsEsp/Canvas.h"
#include "BrunoModsEsp/Paint.h"
#include "BrunoModsEsp/Typeface.h"
#include "Unity/GL/include/bruno_chams.h"
#include "memory/Memory.h"


//----Definir Hooks----//
#define AnogsRealOffset(offset) AgetAbsoluteAddress("libanogs.so",offset)
#define SET(offset, mod, load) DHook((void *)AnogsRealOffset(offset), (void *)mod, (void **)&load)

#define getRealOffset(offset) AgetAbsoluteAddress("libil2cpp.so",offset)
#define GET(offset, ptr, orig) DHook((void *)getRealOffset(offset), (void *)ptr, (void **)&orig)

extern "C" {
JNIEXPORT jobjectArray  JNICALL Java_uk_lgl_modmenu_FloatingModMenuService_BrunoModsFeature(JNIEnv *env, jobject activityObject) {
jobjectArray ret;
    
    const char *features[] = {
		
		    /* --- Aimbot --- */
			"CheckBox_ Aim - Automatico",//0
            "CheckBox_ Aim - Por Tiro",//1
            "CheckBox_ Aim - Por Mira",//2
            "CheckBox_ Aim - Agachado",//3
			"CheckBox_ Aim - Proximo",//4
			"CheckBox_ Draw - Fov",//5
            "SB_ Aim - Fov_0_360",//6
			"SB_ Aim - Distancia_0_200",//7
						
			/* --- Esp / Smps --- */
			"CheckBox_ ESP Fire",//8
			"CheckBox_ ESP Fire Unico",//9
			"CheckBox_ ESP Fire Blue",//10
			"CheckBox_ ESP Granada",//11
            "CheckBox_ ESP Alerta", //12
			"CheckBox_ ESP Name old",//13
						
			/* --- Esp / Draw --- */
			"CheckBox_ ESP Line", //14
			"CheckBox_ ESP Caixa", //15
			"CheckBox_ ESP Esqueleto",//16
			"CheckBox_ ESP Distancia", //17
			"CheckBox_ ESP Moco", //18
			"CheckBox_ ESP Caido",//19
			"CheckBox_ ESP Indentificador",//20
			"CheckBox_ ESP Name",//21
			"CheckBox_ ESP Weapon",//22
			"CheckBox_ ESP Alvo",//23
			"CheckBox_ ESP Alvo Head",//24
			"CheckBox_ ESP Count Playes",//25
		    "CheckBox_ ESP RGB",//26
			"CheckBox_ ESP RGB Distance",//27
			"CheckBox_ ESP 360",//28
			"CheckBox_ ESP Fps",//29
			"CheckBox_ ESP Hp",//30
		    "CheckBox_ ESP Vida",//31
			"CheckBox_ ESP Cicle",//32
			"CheckBox_ ESP Crosshair",//33
			
			/* --- Outros --- */
		    "SBEspG_ ESP Granada Cores_0_6",//34
			"SBEsp_ ESP Cores_0_9",//35
			"SBEsp_ ESP Texto Cor_0_9",//36
			"SB_ ESP Line Posicão_0_2",//37
		    "SBCaixa_ ESP Box Style_0_1",//38
			"SB_ ESP Line Tamanho_0_7",//39
			"SB_ ESP Texto Tamanho_0_11",//40
			"CheckBox_ Wall Chams",//41
			"CheckBox_ Ghost",//42
		    "CheckBox_ Tp Player",//43
		    "CheckBox_ Tp Carro",//44
			"SB_ Speed Time_0_10",//45
		    "CheckBox_ Limpar Conta Convidado",//46
			};

           int Total_Feature = (sizeof features / sizeof features[0]); ret = (jobjectArray) env->NewObjectArray(Total_Feature, env->FindClass("java/lang/String"), env->NewStringUTF("")); int i; for (i = 0; i < Total_Feature; i++) env->SetObjectArrayElement(ret, i, env->NewStringUTF(features[i]));
	        
           return (ret);
}

/*----- MemoryPatch -----*/
Memory BypassCheats;
 
MemoryPatch Get_Instance;

MemoryPatch CarroMap;
MemoryPatch UnderMap;

MemoryPatch Speed0x;
MemoryPatch Speed1x;
MemoryPatch Speed2x;
MemoryPatch Speed3x;
MemoryPatch Speed4x;
MemoryPatch Speed5x;
MemoryPatch Speed6x;
MemoryPatch Speed7x;
MemoryPatch Speed8x;
MemoryPatch Speed9x;
MemoryPatch Speed10x;

//----- AimBot -----//

bool aimFov = true;
bool ingrCaido = false;
bool FixFov = true;
bool aimAuto = false;
bool aimFire = false;
bool aimScope = false;
bool aimCrouch = false;
bool aimGrenade = false;
bool AimLegit = false;
bool AimVisible = false;

bool aimProximo = false;
bool aimEscolhe;
bool aimProximoAct = false;
bool Tipos2Aim = false;

//----- Esp -----//

bool EspGranada = false;
bool EspDistancia = false;
bool EspLine = false;
bool EspBox = false;
bool EspCicle = false;
bool EspSeta = false;
bool EspMoco = false;
bool EspPosicao = false;
bool AlertAroundEnmy = false;
bool EspWeapon = false;
bool EspInden = false;
bool EspPosi = false;
bool EspEsqueleto = false;
bool EspCont =false;
bool EspHp = false;
bool EspPs = false;
bool CrossHairLine = false;
bool EspAlvo = false;;
bool EspNameDraw = false;
bool EspFire = false;
bool EspNames = false;
bool EspFireAzul = false;
bool EspCaidos = false;
bool EspAlerta = false;
bool Esp360 = false;
bool EspAlvoo = false;
bool EspFireAlvo = false;
bool EspFps = false;
bool EspAlvoUnico = false;
bool EspCout = false;
bool Random = false;
bool EspAlvoHead = false;
bool RgbDistance = false;
bool DrawFov = false;
bool EspVidav2 = false;
bool EspBoxStrock = false;
bool EspBoxStrock1 = true;
bool EspBoxStrock2 = false;
bool EspBoxStrock3 = false;
bool EspBoxStrock4 = false;
bool EspBoxStrock5 = false;
bool EspBoxStrock6 = false;
bool EspBoxStrock7 = false;
bool EspBoxStrock8 = false;
bool EspBoxStrock9 = false;
bool EspBoxStrock10 = false;
bool FireBlue = false;

bool Bypass = false;

//----- Ghost etc -----//
bool EspVeiculo = false;
bool Speed = false;
bool Ghost = false;
bool TpPlayer = false;
bool TpCar = false;
bool UnderCar = false;
bool FlyCar = false;
bool RgbDist = false;
bool TpCarro = false;
bool WallPedra = false;
bool TpAliado = false;
bool limparconta = false;
bool DoubleGun = false;
bool Prancha = false;
bool Teste3 = false;
bool Teste4 = false;
bool FlyPlayer = false;

int PrachaY = 0;
int FlyDrive = 0;
int UnderDrive = 0;

//----- Float -----//
float mScale;
float HP2;
float AimSmooth = 0.0f;
float Fov_Aim = 4.0f;

//----- Int -----//

int Semihs = 0;
int m_gSWidth;
int m_gSHeight;
int AimSpoot = 0;
int AimDistance = 0;
int AimFov = 0;
int FramePerS;
int HpS;
int Boards = 0;

int R = 255;
int G = 255;
int B = 255;
    
//Fly
bool FlyAltura = false;
bool Gravidade = false;

float TFPosX = 0.0f;
float TFPosY = 0.0f;
float TFPosZ = 0.0f;
void *TFPos = nullptr;

int instance_FLY = 1;

int velocidade = 0;
bool Verificacao = false;



//Teste
bool FlySpeed = false;
int SpeedVelocidade = 0;

//----- Outros -----//
int enemyCountAround = 0;
int botCountAround = 0;
//----- Color -----//

Color GranadaColor = Color::Blue();
Color GranadaColors = Color::Red();
Color LineColor = Color::White();
Color TextColor = Color::White();
Color RamdonS = Color::White();
Color Color360F = Color::Blue();
Color Cor360 = Color::White();
Color CaidoColor = Color::Red();

float TextSize = 12.0f;
float Linesize = 1;
float CrossSize = 17;
float CheckFov = 0;

//----- Chams -----//
bool ChamsEsp = false;
bool ChamsCor = true;

//----- Inciar pthread etc-----//
bool active = true;
bool launched = false;



JNIEXPORT void JNICALL Java_uk_lgl_modmenu_FloatingModMenuService_BrunoModsChanges(JNIEnv *env, jobject activityObject, jint feature, jint Value) {
        
    switch (feature) {

            case 0:
            aimAuto = !aimAuto;
            break;

            case 1:
            aimFire = !aimFire;
            break;

            case 2:
            aimScope = !aimScope;
            break;

            case 3:
            aimCrouch = !aimCrouch;
            break;
			
			case 4:
			aimProximoAct = !aimProximoAct;
			if (aimProximoAct) {
            aimEscolhe = true;
			} else {
            aimEscolhe = false;
			}
			break;
			
			case 5:
			DrawFov = !DrawFov;
			break;
			
			case 6:
			if (Value > 0) {
            AimFov = (float)Value;
            break;
			
			case 7:
			AimDistance = (float)Value;
			break;		
	
			case 8: 
            EspFire = !EspFire;
            break;
    
			case 9:
			EspFireAlvo = !EspFireAlvo;
			break;
			
			case 10:
		    FireBlue = !FireBlue;
			break;
  
			case 11:
            EspGranada = !EspGranada;
            break;
			
            case 12: 
            EspAlerta = !EspAlerta;
            break;
			
			case 13:
            EspPs = !EspPs;
            break;
		
		    case 14:
			EspLine = !EspLine;
			break;
			
			case 15:
			EspBox = !EspBox;
			break;
			
			case 16:
		    EspEsqueleto = !EspEsqueleto;
			break;
			
		    case 17:
			EspDistancia = !EspDistancia;
			break;
			
			case 18:
		    EspMoco = !EspMoco;
            break;
		
		    case 19:
            EspCaidos = !EspCaidos;
            break;
		
		    case 20:
		    EspInden = !EspInden;
		    break;
		  
		    case 21:
		    EspNameDraw = !EspNameDraw;
		    break;
		  
		    case 22:
		    EspWeapon = !EspWeapon;
		    break;
		  
			case 23:
			EspAlvoUnico = !EspAlvoUnico;
			break;
			
			case 24:
			EspAlvoHead = !EspAlvoHead;
			break;
			
			case 25:
			EspCout = !EspCout;
			break;
			
		    case 26:
		    Random = !Random;
		    break;
		
			case 27:
			RgbDist = !RgbDist;
			break;
			
		    case 28:
		    Esp360 = !Esp360;
	 	    break;
		  
		    case 29:
		    EspFps = !EspFps;
		    break;
			
			case 30:
			EspHp = !EspHp;
			break;
			
			case 31:
			EspVidav2 = !EspVidav2;
		    break;
			
			case 32:
			EspCicle = !EspCicle;
			break;
			
		    case 33:
		    CrossHairLine = !CrossHairLine;
		    break;
			
			case 34:
			if (Value == 0) {
				GranadaColor = Color::Blue();
				
			} else if (Value == 1) {
				GranadaColor = Color::Green();
				
			} else if (Value == 2) {
				GranadaColor = Color::Red();
				
			} else if (Value == 3) {
				GranadaColor = Color::White();

			} else if (Value == 4) {
				GranadaColor = Color::Yellow();
				
			} else if (Value == 5) {
				GranadaColor = Color::Cyan();
				
			} else if (Value == 6) {
				GranadaColor = Color::Magenta();
				
			}
            break;
			
		    case 35:
			if (Value == 0) {
				LineColor = Color::White();
				EspBoxStrock1 = true;
				EspBoxStrock2 = false;
				EspBoxStrock3 = false;
				EspBoxStrock4 = false;
				EspBoxStrock5 = false;
				EspBoxStrock6 = false;
				EspBoxStrock7 = false;
				EspBoxStrock8 = false;
				EspBoxStrock9 = false;
				EspBoxStrock10 = false;
				
			} else if (Value == 1) {
				LineColor = Color::Green();
                EspBoxStrock1 = false;
				EspBoxStrock2 = true;
				EspBoxStrock3 = false;
				EspBoxStrock4 = false;
				EspBoxStrock5 = false;
				EspBoxStrock6 = false;
				EspBoxStrock7 = false;
				EspBoxStrock8 = false;
				EspBoxStrock9 = false;
				EspBoxStrock10 = false;
				
			} else if (Value == 2) {
				LineColor = Color::Blue();
                EspBoxStrock1 = false;
				EspBoxStrock2 = false;
				EspBoxStrock3 = true;
				EspBoxStrock4 = false;
				EspBoxStrock5 = false;
				EspBoxStrock6 = false;
				EspBoxStrock7 = false;
				EspBoxStrock8 = false;
				EspBoxStrock9 = false;
				EspBoxStrock10 = false;
				
			} else if (Value == 3) {
				LineColor = Color::Red();
                EspBoxStrock1 = false;
				EspBoxStrock2 = false;
				EspBoxStrock3 = false;
				EspBoxStrock4 = true;
				EspBoxStrock5 = false;
				EspBoxStrock6 = false;
				EspBoxStrock7 = false;
				EspBoxStrock8 = false;
				EspBoxStrock9 = false;
				EspBoxStrock10 = false;

			} else if (Value == 4) {
				LineColor = Color::Black();
                EspBoxStrock1 = false;
				EspBoxStrock2 = false;
				EspBoxStrock3 = false;
				EspBoxStrock4 = false;
				EspBoxStrock5 = true;
				EspBoxStrock6 = false;
				EspBoxStrock7 = false;
				EspBoxStrock8 = false;
				EspBoxStrock9 = false;
				EspBoxStrock10 = false;
				
			} else if (Value == 5) {
				LineColor = Color::Yellow();
                EspBoxStrock1 = false;
				EspBoxStrock2 = false;
				EspBoxStrock3 = false;
				EspBoxStrock4 = false;
				EspBoxStrock5 = false;
				EspBoxStrock6 = true;
				EspBoxStrock7 = false;
				EspBoxStrock8 = false;
				EspBoxStrock9 = false;
				EspBoxStrock10 = false;
				
			} else if (Value == 6) {
				LineColor = Color::Cyan();
                EspBoxStrock1 = false;
				EspBoxStrock2 = false;
				EspBoxStrock3 = false;
				EspBoxStrock4 = false;
				EspBoxStrock5 = false;
				EspBoxStrock6 = false;
				EspBoxStrock7 = true;
				EspBoxStrock8 = false;
				EspBoxStrock9 = false;
				EspBoxStrock10 = false;
				
			} else if (Value == 7) {
				LineColor = Color::Magenta();
				EspBoxStrock1 = false;
				EspBoxStrock2 = false;
				EspBoxStrock3 = false;
				EspBoxStrock4 = false;
				EspBoxStrock5 = false;
				EspBoxStrock6 = false;
				EspBoxStrock7 = false;
				EspBoxStrock8 = true;
				EspBoxStrock9 = false;
				EspBoxStrock10 = false;
				
			} else if (Value == 8) {
				LineColor = Color::Gray();
				EspBoxStrock1 = false;
				EspBoxStrock2 = false;
				EspBoxStrock3 = false;
				EspBoxStrock4 = false;
				EspBoxStrock5 = false;
				EspBoxStrock6 = false;
				EspBoxStrock7 = false;
				EspBoxStrock8 = false;
				EspBoxStrock9 = true;
				EspBoxStrock10 = false;
				
			} else if (Value == 9) {
				LineColor = Color::Purple();
                EspBoxStrock1 = false;
				EspBoxStrock2 = false;
				EspBoxStrock3 = false;
				EspBoxStrock4 = false;
				EspBoxStrock5 = false;
				EspBoxStrock6 = false;
				EspBoxStrock7 = false;
				EspBoxStrock8 = false;
				EspBoxStrock9 = false;
				EspBoxStrock10 = true;
			   }
               break;
            

            case 36:
			if (Value == 0) {
				TextColor = Color::White();
				
			} else if (Value == 1) {
				TextColor = Color::Green();
				
			} else if (Value == 2) {
				TextColor = Color::Blue();
				
			} else if (Value == 3) {
				TextColor = Color::Red();
				
			} else if (Value == 4) {
				TextColor = Color::Black();
				
			} else if (Value == 5) {
				TextColor = Color::Yellow();
				
			} else if (Value == 6) {
				TextColor = Color::Cyan();
				
			} else if (Value == 7) {
				TextColor = Color::Magenta();
				
			} else if (Value == 8) {
				TextColor = Color::Gray();
				
			} else if (Value == 9) {
				TextColor = Color::Purple();
			}
            break;
			
			case 37:
            if (Value == 0) {
			EspAlvo = false;
			EspPosi = false;
		    } else if (Value == 1) {
		    EspAlvo = true;
			EspPosi = false;
            } else if (Value == 2) {
			EspPosi = true;
			EspAlvo = false;
			}
            break;
			
			case 38:
            if (Value == 0) {
			EspBoxStrock = false;
		    } else if (Value == 1) {
		    EspBoxStrock = true;
            }
            break;
			
			case 39:
			if (Value == 0){
			Linesize = Value = 1;
			
			} else if(Value == 1 ){
			Linesize = Value = 1;

			} else if(Value == 2 ){
			Linesize = Value = 2;

			} else if(Value == 3 ){
			Linesize = Value = 3;

			} else if(Value == 4 ){
			Linesize = Value = 4;

			} else if(Value == 5 ){
			Linesize = Value = 5;

			} else if(Value == 6 ){
			Linesize = Value = 6;

			} else if(Value == 7 ){
			Linesize = Value = 7;

			} else if(Value == 8 ){
			Linesize = Value = 8;

			} else if(Value == 9 ){
			Linesize = Value = 9;

			} else if(Value == 10 ){
			Linesize = Value = 10;

            } 
            break;
			
			case 40:
			if (Value == 0 ){
			TextSize = Value = 12;
			} else if(Value == 1 ){
			TextSize = Value = 13;
			} else if(Value == 2 ){
			TextSize = Value = 14;
			} else if(Value == 3 ){
			TextSize = Value = 15;
			} else if(Value == 4 ){
			TextSize = Value = 16;
			} else if(Value == 5 ){
			TextSize = Value = 17;
			} else if(Value == 6 ){
			TextSize = Value = 18;
			} else if(Value == 7 ){
			TextSize = Value = 19;
			} else if(Value == 8 ){
			TextSize = Value = 20;
			} else if(Value == 9 ){
			TextSize = Value = 21;
			} else if(Value == 10 ){
			TextSize = Value = 22;
			} else if(Value == 11 ){
			TextSize = Value = 23;
			}
			break;
			
			case 41:
		    ChamsEsp = !ChamsEsp;
			SetWallhack(ChamsEsp);
		    break;
			
			case 42:
		    Ghost = !Ghost;
		    break;
			
			case 43:
			TpPlayer = !TpPlayer;
			break;
			
			case 44:
		    TpCarro = !TpCarro;
		    break;
			
			case 45:
			if (Value == 0) {
            Speed0x.Restore();
			Speed1x.Restore();
			Speed2x.Restore();
			Speed3x.Restore();
			Speed4x.Restore();
			Speed5x.Restore();
			Speed6x.Restore();
			Speed7x.Restore();
			Speed8x.Restore();
			Speed9x.Restore();
			Speed10x.Restore();
			
            } else if (Value == 1) {
            Speed1x.Modify();
            } else if (Value == 2) {
            Speed2x.Modify();
            } else if (Value == 3) {
            Speed3x.Modify();
            } else if (Value == 4) {
            Speed4x.Modify();
            } else if (Value == 5) {
            Speed5x.Modify();
            } else if (Value == 6) {
            Speed6x.Modify();
            } else if (Value == 7) {
            Speed7x.Modify();
            } else if (Value == 8) {
            Speed8x.Modify();
            } else if (Value == 9) {
            Speed9x.Modify();
            } else if (Value == 10) {
            Speed10x.Modify();
            }          
            break;
			
			case 46:
			limparconta = !limparconta;
			if (limparconta) {
				
			remove("/storage/emulated/0/com.garena.msdk/guest100067.dat");
			remove("/storage/emulated/0/Android/data/com.dts.freefireth/files/reportnew.db");
		    remove("/storage/emulated/0/Android/data/com.dts.freefireth/files/ymrtc_log.txt");
            break;
			
		    }
		 }
      } 
   }
}


//-------Head e Hip-------//
Vector3 GetHeadPosition(void* player) {
    return Transform_INTERNAL_GetPosition(*(void**) ((uint64_t) player + Global.HeadTF));
}

Vector3 GetHipsPosition(void* player) {
    return Transform_INTERNAL_GetPosition(*(void**) ((uint64_t) player + Global.HipsTF));
}

Vector3 GetToeTFPosition(void* player) {
    return Transform_INTERNAL_GetPosition(*(void**) ((uint64_t) player + Global.ToeTF));
}

Vector3 GetShoEPosition(void* player) {
    return Transform_INTERNAL_GetPosition(*(void**) ((uint64_t) player + Global.OmbroE));
}

Vector3 GetShoDPosition(void* player) {
    return Transform_INTERNAL_GetPosition(*(void**) ((uint64_t) player + Global.OmbroD));
}

Vector3 GetHenEPosition(void* player) {
    return Transform_INTERNAL_GetPosition(*(void**) ((uint64_t) player + Global.BracoE));
}

Vector3 GetHenDPosition(void* player) {
    return Transform_INTERNAL_GetPosition(*(void**) ((uint64_t) player + Global.BracoD));
}

Vector3 GetToeEPosition(void* player) {
    return Transform_INTERNAL_GetPosition(*(void**) ((uint64_t) player + Global.PernaE));
}

Vector3 GetToeDPosition(void* player) {
    return Transform_INTERNAL_GetPosition(*(void**) ((uint64_t) player + Global.PernaD));
}

static Vector3 WorldToScreenPoint(void *WorldCam, Vector3 WorldPos) {
    Vector3 (*_WorldToScreenScene)(void* Camera, Vector3 position) = (Vector2 (*)(void*, Vector3)) getRealOffset(Global.WorldToScreenPoint);
    return _WorldToScreenScene(WorldCam,WorldPos);
}

static void *VehicleIAmIn(void *Vehicle) {
    void *(*_VehicleIAmIn)(void *Vehicles) = (void *(*)(void *))getRealOffset(0x8ba89c);
    return _VehicleIAmIn(Vehicle);
}

static void *GetVehicleIAmIn(void *Vehicle) {
    void *(*_GetVehicleIAmIn)(void *Vehicles) = (void *(*)(void *))getRealOffset(0x8bb740);
    return _GetVehicleIAmIn(Vehicle);
}

Vector3 CameraMain(void* player){
    return Transform_INTERNAL_GetPosition(*(void**) ((uint64_t) player + Global.MainCameraTransform));
}


//---- Valo NULL Etc -----//

void *get_BrunoCanvas = nullptr;
void *get_BrunoEsp(void *BrunoxT7) {
      get_BrunoCanvas = BrunoxT7;
      return get_BrunoCanvas;
}

void *GrenadeLine = nullptr;
void *RenderLine = nullptr;
   
Vector3 AlvoEnemyPos = Vector3(0,0,0);
Vector3 AlvoLocalPos = Vector3(0,0,0);

//----- closets enemy -----//
void *GetClosestEnemy(void *match) {
	
    if (!match) return nullptr;
    
	float AimbotDistance = 99999.0f;
    float AimbotAngle = AimFov;
	float angleAimbot = 360.0f;
    float aimSmooth = AimSmooth;
		
    void* closestEnemy = nullptr;
    void* LocalPlayer = GetLocalPlayer(match);
    
    if (LocalPlayer != nullptr && !get_IsDieing(LocalPlayer)) {
		
		monoDictionary<uint8_t *, void **> *players = *(monoDictionary<uint8_t*, void **> **)((long)match + Global.Dictionary);
                     
        for(int u = 0; u < players->getNumValues(); u++) {
        void* PlayerEnemy = players->getValues()[u];
			
           if (PlayerEnemy != nullptr && !get_isLocalTeam(PlayerEnemy) && !get_IsDieing(PlayerEnemy) && get_isVisible(PlayerEnemy) && get_MaxHP(PlayerEnemy)) {
			   
               Vector3 EnemyTFPos = GetHeadPosition(PlayerEnemy);
               Vector3 LocalTFPos = GetHeadPosition(LocalPlayer);
			   
			   float distance = Vector3::Distance(EnemyTFPos, LocalTFPos);
			   
			   void *imo = get_imo(LocalPlayer);
			   
			   if (EspFire && imo != nullptr) {
			   if (FireBlue) {
               set_esp1(imo, LocalTFPos, EnemyTFPos);
               } else {
			   set_esp(imo, LocalTFPos, EnemyTFPos);
			   }
			   }
			   
		       
			   if (!aimEscolhe) {
               Vector3 TargetInit = Vector3::Normalized(EnemyTFPos - LocalTFPos);
               float angulos = Vector3::Angle(TargetInit, GetForward(Component_GetTransform(Camera_main()))) * 100.0;
					
               if (angulos <= AimbotAngle) {
               if (angulos < AimbotDistance) {
						
               AimbotDistance = angulos;
						 
               closestEnemy = PlayerEnemy;
               }
               }
               } else {
						
               if (AimbotAngle < AimbotDistance) {
				   
               AimbotDistance = AimbotAngle;
               closestEnemy = PlayerEnemy;
               }
               }
			   
			
			   if (aimProximo) {
			   Vector3 fwd = GetForward(Component_GetTransform(Camera_main())) * angleAimbot;
	     	   Vector3 nrml = Vector3::Normalized(EnemyTFPos - LocalTFPos);
					
			   float angle = Vector3::Angle(nrml, fwd);
			
			   if (angle <= angleAimbot) {
			   if (distance < AimbotDistance) {
			
			   AimbotDistance = distance;
			   
			   closestEnemy = PlayerEnemy;
			   }
			   }
			   } else {
				 
			   if (distance < AimbotDistance) {
					
               AimbotDistance = distance;
               closestEnemy = PlayerEnemy;
			   }
			   }
            }
        }
    }
    return closestEnemy;
}



void EspAndAimbot(void *LocalPlayer, void *enemy_player){

void *currentMatch = Curent_Match();
		
  if (LocalPlayer != nullptr && enemy_player != nullptr && currentMatch != nullptr) {
		
     if (EspCout) {
			
     int tmpEnemyCountAround = 0;
     int tmpBotCountAround = 0;
            
     monoDictionary<uint8_t *, void **> *players = *(monoDictionary<uint8_t *, void **> **) ((long)currentMatch + Global.Dictionary);
	 void *Camera = Camera_main();
	 if (players != nullptr && Camera != nullptr && players->getNumValues() > 0) {
                                              
     for (int u = 0; u < players->getNumValues(); u++) {
		 
     void *enemy_player = players->getValues()[u];
                    
     enemyCountAround = tmpEnemyCountAround;
     botCountAround = tmpBotCountAround;
                    
     if (enemy_player != nullptr && enemy_player != LocalPlayer && !get_isLocalTeam(enemy_player) && get_isVisible(enemy_player) && get_MaxHP(enemy_player)) {
                   
	 if (enemy_player != nullptr) {
		 
       bool isBot = *(bool*)((uintptr_t)enemy_player + Global.IsClientBot);
	 
       if (isBot) {
          ++tmpBotCountAround;
       } else {
          ++tmpEnemyCountAround;
       }
       }
	
	   if (enemy_player != LocalPlayer) {
	   
       }
       } 
    }
}
}
}
}

//---- Update AimBot -----//
void (*Update)(void* Brunomods);
void _Update(void* Brunomods) {
	
	Update(Brunomods);
	
    if (Brunomods) {
        void* Match = Curent_Match();
		void *Camera = Camera_main();
		
		if ((aimAuto || aimFire || aimScope || aimCrouch) && Match) {
            void* LocalPlayer = GetLocalPlayer(Match);
			
              if (LocalPlayer) {	
			    
			    if (FlyCar) {
				if (get_IsDriver(LocalPlayer)) {
			       CarroMap.Modify();
                } else {
			       CarroMap.Restore();
			    }
				}
			    
			    if (UnderCar) {
				if (get_IsDriver(LocalPlayer)) {
			      UnderMap.Modify();
                } else {
		          UnderMap.Restore();
			    }                     
			    }
				
				
                void* closestEnemy = GetClosestEnemy(Match);
				
                if (closestEnemy && Camera != nullptr && !get_IsDieing(closestEnemy)) {
					
				    EspAndAimbot(LocalPlayer, closestEnemy);
				      				
                    Vector3 EnemyHeadLocation = GetHeadPosition(closestEnemy);
					Vector3 LocalHeadLocation = GetHeadPosition(LocalPlayer);
					Vector3 LocalHipsLocation = GetHipsPosition(LocalPlayer);
					
					Quaternion PlayerHead = GetRotationToLocation(GetHeadPosition(closestEnemy), 0.1f, CameraMain(LocalPlayer));
			        Quaternion PlayerHips = GetRotationToLocation(GetHipsPosition(closestEnemy), 0.1f, CameraMain(LocalPlayer));
			        Quaternion PlayerToes = GetRotationToLocation(GetToeTFPosition(closestEnemy), 0.1f, CameraMain(LocalPlayer));
			        
					Quaternion HeadSmooth = Quaternion::Lerp(PlayerHead, PlayerHead, 2.0F);
			        Quaternion HipsSmooth = Quaternion::Lerp(PlayerHips, PlayerHips, 2.0F);
			        Quaternion ToesSmooth = Quaternion::Lerp(PlayerToes, PlayerToes, 2.0F);
			  
			       
					void *ui = CurrentUIScene();
				    void *imo = get_imo(LocalPlayer);
					
					AlvoEnemyPos = WorldToScreenPoint(Camera, GetHeadPosition(closestEnemy));
					AlvoLocalPos = WorldToScreenPoint(Camera, GetHeadPosition(LocalPlayer));
					
				    float distance = Vector3::Distance(GetHipsPosition(LocalPlayer), GetHeadPosition(closestEnemy));
					
					if (AimDistance < 1) AimDistance = 140;
                    if (AimDistance > distance) {
					
				  
					if (EspPs && ui != nullptr) {
                    
                    BrunoModsString(ui, String_Concat, get_NickName(closestEnemy), DistBrunoMods(distance), 2.0f);
					}
					
                    if (EspAlerta && ui != nullptr) {
		
                    monoString *nick = get_NickName(closestEnemy);
					
				    ShowAssistantText(ui, nick, BrunoMods1(distance));
					
					bool get_Bots = *(bool *) ((uintptr_t) closestEnemy + Global.IsClientBot);
                    
				    if (get_Bots) {
                      ShowAssistantText(ui, nick, BrunoMods2(distance));
				    } else if (get_Tiro(closestEnemy)) {
                      ShowAssistantText(ui, nick, BrunoMods3(distance));
				    } else if (get_Mira(closestEnemy)) {
                      ShowAssistantText(ui, nick, BrunoMods4(distance));
				    } else if (get_Driv(closestEnemy)) {
                      ShowAssistantText(ui, nick, BrunoMods5(distance));
				    } else if (get_KitM(closestEnemy)) {
                      ShowAssistantText(ui, nick, BrunoMods6(distance));
                    } else if (get_Skat(closestEnemy)) {
					  ShowAssistantText(ui, nick, BrunoMods7(distance));
				    } else if (get_Prch(closestEnemy)) {
					  ShowAssistantText(ui, nick, BrunoMods8(distance));
					} else if (get_Crep(closestEnemy)) {
					  ShowAssistantText(ui, nick, BrunoMods9(distance));
				    } else if (get_Swig(closestEnemy)) {
					  ShowAssistantText(ui, nick, BrunoMods10(distance));
					} else if (get_Alid(closestEnemy)) {
					  ShowAssistantText(ui, nick, BrunoMods11(distance));
					} else if (get_Croc(closestEnemy)) {
					  ShowAssistantText(ui, nick, BrunoMods13(distance));
					} else if (get_Grnd(closestEnemy)) {
					  ShowAssistantText(ui, nick, BrunoMods14(distance));
					} else if (get_Knif(closestEnemy)) {
					  ShowAssistantText(ui, nick, BrunoMods15(distance));
					} else if (get_Cmfg(closestEnemy)) {
					  ShowAssistantText(ui, nick, BrunoMods16(distance));
					}
					}
					
					if (EspFireAlvo && imo != nullptr) {
					if (FireBlue) {
                    set_esp1(imo, LocalHipsLocation, EnemyHeadLocation);
                    } else {
					set_esp(imo, LocalHipsLocation, EnemyHeadLocation);
					}
					}
					
					if(EspGranada && RenderLine) {
					((void (*)(void *, Color))getRealOffset(0x2a918D4))(RenderLine, GranadaColor);
                    ((void (*)(void *, Color))getRealOffset(0x2a91978))(RenderLine, GranadaColor);
                    GrenadeLine_DrawLine(GrenadeLine, LocalHeadLocation, EnemyHeadLocation, Vector3(0,1,0) * 0.6);
                    LineRenderer_Set_PositionCount(RenderLine, 0x2);
                    LineRenderer_SetPosition(RenderLine, 0, LocalHeadLocation);
                    LineRenderer_SetPosition(RenderLine, 1, EnemyHeadLocation);
                    }
                    
                    if (TpCarro) {
	                void* LocalCar = VehicleIAmIn(LocalPlayer);
                    if (LocalCar) {
                    Set_Position(Component_GetTransform(LocalCar), Vvector3(EnemyHeadLocation.X, EnemyHeadLocation.Y + 0.6f, EnemyHeadLocation.Z));
                    }
                    }
					
					
				    if (TpPlayer) {
					if (get_IsFiring(LocalPlayer)) {
					} else {
				    Set_Position(Component_GetTransform(LocalPlayer), Vvector3(EnemyHeadLocation.X, EnemyHeadLocation.Y + 0.1f, EnemyHeadLocation.Z + 0.9f));
					}
					}
					
					if (TpAliado) {
					if (get_isLocalTeam(closestEnemy)) {
				    Set_Position(Component_GetTransform(LocalPlayer), Vvector3(EnemyHeadLocation.X, EnemyHeadLocation.Y + 0.1f, EnemyHeadLocation.Z + 0.9f));
					}
					}
					
				    if (aimAuto) {
                    set_aim(LocalPlayer, PlayerHead);
		            }
			   
			        if (aimFire && get_IsFiring(LocalPlayer)) {     
                    set_aim(LocalPlayer, PlayerHead);
                    }
                    
                    if (aimScope && get_IsSighting(LocalPlayer)) {          
                    set_aim(LocalPlayer, PlayerHead);
                    }
				
		            if (aimCrouch && get_IsCrouching(LocalPlayer)) {          
                    set_aim(LocalPlayer, PlayerHead);
                  }
			  }
          }
      }
  }
  }
  get_BrunoEsp(Brunomods);
  Update(Brunomods);
}


static bool isEspReady() {
	return false;
}


ESP espOverlay;
void DrawESP(ESP esp, int ScreenWidth, int ScreenHeight) {
		   
    if (CrossHairLine) {
    esp.DrawCrosshair(LineColor, Vector3(ScreenWidth / 2, ScreenHeight / 2), CrossSize);
    esp.DrawCircle(LineColor, 3, Vector3(ScreenWidth / 2, ScreenHeight / 2), CrossSize);
	esp.DrawCircle(LineColor, 3, Vector3(ScreenWidth / 2, ScreenHeight / 2), 23);
    }

	if (DrawFov) {
    esp.DrawCircle(LineColor, 3, Vector3(ScreenWidth / 2, ScreenHeight / 2), AimFov);
    }
  
    if (EspFps && !EspCout) {
    char fpsCount[30];
    int fps = FramePerS;
    sprintf(fpsCount, " BrunoDev / FRAMES: %d ", fps);
    esp.DrawText(TextColor, fpsCount, Vector3(ScreenWidth / 2, ScreenHeight / 6), 26);
    }
	 
	if (EspCout && !EspFps) {
    char CountP[128] = {};
    sprintf(CountP, " Players: %d  Bots: %d ", enemyCountAround, botCountAround);
    esp.DrawText(TextColor, CountP, Vector3(ScreenWidth / 2, ScreenHeight / 6), 26);
    }
	
	if (EspCout && EspFps) {
    char CountP[128] = {};
	int fps = FramePerS;
    sprintf(CountP, " Players: %d / FRAMES: %d ", enemyCountAround, fps);
    esp.DrawText(TextColor, CountP, Vector3(ScreenWidth / 2, ScreenHeight / 6), 26);
    }
			  
	if (Random) {
    LineColor = Color((long)rand()%R, rand()%G, rand()%B, 255);
    TextColor = Color((long)rand()%R, rand()%G, rand()%B, 255);
    }    
		   
           void *BrunoXDev = get_BrunoCanvas;
	 
            if (BrunoXDev != nullptr) {
			  
	           void *current_Match = Curent_Match();
		
	           void* local_player = GetLocalPlayer(current_Match);
		 
	           if (local_player != nullptr && current_Match != nullptr) {
		
		          if (!isEspReady()) {
					
                  monoDictionary<uint8_t *, void **> *players = *(monoDictionary<uint8_t*, void **> **)((long)current_Match + Global.Dictionary);
		          void *Camera = Camera_main();
				
				  if (players != nullptr && Camera != nullptr) {
				  
                  for(int u = 0; u < players->getNumValues(); u++) {
                   
		          void* closestEnemy = players->getValues()[u];
				
                  if (closestEnemy != local_player && closestEnemy != nullptr && get_isVisible(closestEnemy) && !get_isLocalTeam(closestEnemy)) {
					 
				  float Tamanho = 0.0f;             
					
			      Vector3 HeadPos = WorldToScreenPoint(Camera, GetHeadPosition(closestEnemy));
			      Vector3 Head360 = WorldToScreenPoint(Camera, GetHeadPosition(closestEnemy));
				  Vector3 HipsPos = WorldToScreenPoint(Camera, GetHipsPosition(closestEnemy));
	              Vector3 ShoEPos = WorldToScreenPoint(Camera, GetShoEPosition(closestEnemy));
                  Vector3 ShoDPos = WorldToScreenPoint(Camera, GetShoDPosition(closestEnemy));
                  Vector3 HenEPos = WorldToScreenPoint(Camera, GetHenEPosition(closestEnemy));
                  Vector3 HenDPos = WorldToScreenPoint(Camera, GetHenDPosition(closestEnemy));
                  Vector3 ToeEPos = WorldToScreenPoint(Camera, GetToeEPosition(closestEnemy));
                  Vector3 ToeDPos = WorldToScreenPoint(Camera, GetToeDPosition(closestEnemy));
                  Vector3 ToeBPos = WorldToScreenPoint(Camera, GetToeTFPosition(closestEnemy));
				 
				  if (HeadPos.Z < -0) continue;
				  if (HipsPos.Z < -0) continue;
			      if (ShoDPos.Z < -0) continue;
		          if (ShoEPos.Z < -0) continue;
			      if (HenEPos.Z < -0) continue;
		          if (HenDPos.Z < -0) continue;
		          if (ToeEPos.Z < -0) continue;
			      if (ToeDPos.Z < -0) continue;
			      if (ToeBPos.Z < -0) continue;

		 		  float distance = Vector3::Distance(GetHeadPosition(local_player), GetHeadPosition(closestEnemy));
                                  
                  if (distance > 10.0f) {
					  
                  Tamanho = 10.0f;
				  
                  } else if (distance < 20.0f) {
					  
                  Tamanho = 0.0f;
				  }
                                            
				  float boxWidth = static_cast<float>(((ScreenWidth - ShoEPos.X * 0.995) - (ScreenWidth - ShoDPos.X * 1.005)) * 1.2);
				  
			      float boxHeight = ((ScreenHeight - ToeBPos.Y) - (ScreenHeight - HeadPos.Y));
				 
		          Rect PlayerRect(ToeBPos.X - (boxWidth / 2), (ScreenHeight - HeadPos.Y) -Tamanho / 2, boxWidth, boxHeight + Tamanho);
                                           
				  monoString* PlayName = get_NickName(closestEnemy);
				  string playnick;
                  if (EspNameDraw) {
					  
                  int NickBrunoMods = PlayName->getLength();
                                    
                  for (int i = 0; i < NickBrunoMods; i++) {
                  char data = get_Chars(PlayName, i);
                  playnick += isascii(data) ? data : ' ';
                  }
				  
                  if (EspLine) {
				   esp.DrawLine(LineColor, Linesize, Vector3((ScreenWidth / 2), 0), Vector3((ScreenWidth - (ScreenWidth - HeadPos.X)), (ScreenHeight - HeadPos.Y)));
				  }
				  
				  if (EspBox) { 
				  esp.DrawBox(LineColor, Linesize, PlayerRect);
				  }
				  	  
			      if (EspPosi) {
			      esp.DrawLine(LineColor, Linesize, Vector3(ScreenWidth / 2, ScreenHeight / 1),Vector3((ScreenWidth - (ScreenWidth - HeadPos.X)), (ScreenHeight - HeadPos.Y)));     
			      } 
				  
			      if (EspAlvo) {
				  esp.DrawLine(LineColor, Linesize, Vector3(ScreenWidth / 2, ScreenHeight / 2), Vector3((ScreenWidth - (ScreenWidth - HeadPos.X)), (ScreenHeight - HeadPos.Y)));
				  }
				    
				  if (AlvoEnemyPos.Z < -0) continue;
				  if (EspAlvoUnico && (AimFov > 1.0f && aimAuto || aimFire || aimCrouch || aimScope)) {
                  esp.DrawLine(Color::DarkGolden(), 2 ,Vector3(ScreenWidth / 2 ,ScreenHeight / 2), Vector3((ScreenWidth - (ScreenWidth - AlvoEnemyPos.X)), ScreenHeight - AlvoEnemyPos.Y));
                  }
				  
				  if (AlvoLocalPos.Z < -0) continue;
				  if (EspAlvoHead && (AimFov > 1.0f && aimAuto || aimFire || aimCrouch || aimScope)) {
                  esp.DrawLine(LineColor, Linesize, Vector3((ScreenWidth - (ScreenWidth - AlvoLocalPos.X)), (ScreenHeight - AlvoLocalPos.Y)), Vector3((ScreenWidth - (ScreenWidth - AlvoEnemyPos.X)), (ScreenHeight - AlvoEnemyPos.Y)));
                  }
                  
				  if (EspMoco) {
				  esp.DrawText(LineColor, " ▼ " , Vector3((ScreenWidth -(ScreenWidth - HeadPos.X)),(ScreenHeight - HeadPos.Y) - 40.0f), 17.0f);
				  }
				  
				  if (EspLine && EspCaidos) {
				  if (get_IsDieing(closestEnemy)) {
				   esp.DrawLine(CaidoColor, Linesize, Vector3((ScreenWidth / 2), 0), Vector3((ScreenWidth - (ScreenWidth - HeadPos.X)), (ScreenHeight - HeadPos.Y)));
				  }
				  }
				  
				  if (EspBox && EspCaidos) {
				  if (get_IsDieing(closestEnemy)) {
				  esp.DrawBox(CaidoColor, Linesize, PlayerRect);
				  }
				  }
				  
				  if (RgbDist) {
				  Color ColorDistance = Distance((int)distance);
                  LineColor = ColorDistance;
				  TextColor = ColorDistance;
				  }
				  
			      if (EspNameDraw && !EspWeapon) {
                  esp.DrawText(TextColor, playnick.c_str(), Vector3(ScreenWidth - (ScreenWidth - HeadPos.X), ScreenHeight - HeadPos.Y - 12.0f), TextSize);                          
                  }
				 
                  if (EspWeapon && !EspNameDraw) {	    
				  string weaponEquiped;         
                  weaponEquiped += " ";
                  weaponEquiped += NameWeapon(GetWeaponType(closestEnemy));
                  weaponEquiped += " ";
                             
                  esp.DrawText(TextColor, weaponEquiped.c_str(), Vector3(PlayerRect.x + (PlayerRect.width / 2), PlayerRect.y - 15.0f), TextSize);
                  }
				
			
                  if (EspWeapon && EspNameDraw) {
                  string playerName;
                  playerName += "";
                  playerName += playnick;
                  playerName += "  ";
                  playerName += "Usando: ";
                  playerName += NameWeapon(GetWeaponType(closestEnemy));
                  playerName += " ";
                                
                  esp.DrawText(TextColor, playerName.c_str(), Vector3(PlayerRect.x + (PlayerRect.width / 2), PlayerRect.y - 12.0f), TextSize);
                  }		 
				
				  float SizeCabecaSke = 5.0f;
                  if (distance < 10) {
                     SizeCabecaSke = 10.0f;
                  } else if (distance > 10 && distance < 30) {
                     SizeCabecaSke = 4.0f;
                  } else if (distance > 30 && distance < 50) {
                     SizeCabecaSke = 3.0f;
                  } else if (distance > 50 && distance < 70) {
                     SizeCabecaSke = 2.0f;
                  } else if (distance > 70) {
                     SizeCabecaSke = 1.0f;
                  }
                  if (EspEsqueleto) {
				  esp.DrawCircle(LineColor, 1.0f, Vector3((ScreenWidth - (ScreenWidth - HeadPos.X)), (ScreenHeight - HeadPos.Y) -2.0f), SizeCabecaSke);                                                                                            
			      esp.DrawLine(LineColor, 1.0f, Vector3((ScreenWidth - (ScreenWidth - HipsPos.X)),(ScreenHeight - HipsPos.Y)),Vector3((ScreenWidth - (ScreenWidth - HeadPos.X)),(ScreenHeight - HeadPos.Y)));
			      esp.DrawLine(LineColor, 1.0f, Vector3((ScreenWidth - (ScreenWidth - ShoEPos.X)),(ScreenHeight - ShoEPos.Y)),Vector3((ScreenWidth - (ScreenWidth - HeadPos.X)),(ScreenHeight - HeadPos.Y)));
			      esp.DrawLine(LineColor, 1.0f, Vector3((ScreenWidth - (ScreenWidth - ShoDPos.X)),(ScreenHeight - ShoDPos.Y)),Vector3((ScreenWidth - (ScreenWidth - HeadPos.X)),(ScreenHeight - HeadPos.Y)));
			      esp.DrawLine(LineColor, 1.0f, Vector3((ScreenWidth - (ScreenWidth - ToeEPos.X)),(ScreenHeight - ToeEPos.Y)),Vector3((ScreenWidth - (ScreenWidth - HipsPos.X)),(ScreenHeight - HipsPos.Y)));
			      esp.DrawLine(LineColor, 1.0f, Vector3((ScreenWidth - (ScreenWidth - ToeDPos.X)),(ScreenHeight - ToeDPos.Y)),Vector3((ScreenWidth - (ScreenWidth - HipsPos.X)),(ScreenHeight - HipsPos.Y)));
			      esp.DrawLine(LineColor, 1.0f, Vector3((ScreenWidth - (ScreenWidth - HenEPos.X)),(ScreenHeight - HenEPos.Y)),Vector3((ScreenWidth - (ScreenWidth - ShoEPos.X)),(ScreenHeight - ShoEPos.Y)));
			      esp.DrawLine(LineColor, 1.0f, Vector3((ScreenWidth - (ScreenWidth - HenDPos.X)),(ScreenHeight - HenDPos.Y)),Vector3((ScreenWidth - (ScreenWidth - ShoDPos.X)),(ScreenHeight - ShoDPos.Y)));
			      }								
				  
			      if (EspCicle) {
			      esp.DrawCircle(LineColor, 1, Vector3((ScreenWidth - (ScreenWidth - HipsPos.X)), ScreenHeight - HipsPos.Y), 19);
			      }
			 		 
		          if (EspHp) {
			      int Health = GetHp(closestEnemy);
                  char Hps[128] = {};
                  sprintf(Hps, " HP = %d ", Health);
                  esp.DrawText(TextColor, Hps, Vector3(PlayerRect.x + (PlayerRect.width / 2), PlayerRect.y - 30.5f), TextSize);           
			      }
				  
			      if (EspDistancia) {
				  char dstc[50];
		   
                  sprintf(dstc, "%.2f M", distance);
				  
				  std::string dist;
				  
                  dist += "[ ";
                  dist += dstc;
                  dist += "";
				  
				  bool IsBot = *(bool*)((uintptr_t)closestEnemy + Global.IsClientBot);
								  
                  if (IsBot) {
                  dist += " BOT";
                  } else {
                  dist += " JOGADOR REAL";
                  if (EspInden) {
                  if (get_Tiro(closestEnemy)) {
                  dist += " = Atirando";
                  }
				  if (get_Mira(closestEnemy)) {
                  dist += " = Mirando";
                  } 
				  if (get_IsDieing(closestEnemy)) {
                  dist += " = Derrubado";
				  }
				  if (get_Driv(closestEnemy)) {
                  dist += " = No veiculo";
                  }
				  if (get_KitM(closestEnemy)) {
                  dist += " = Se Curando";
                  }
				  if (get_Skat(closestEnemy)) {
                  dist += " = Surfando no ceu";
                  }
				  if (get_Prch(closestEnemy)) {
                  dist += " = No paraquedas";
                  }
				  if (get_Crep(closestEnemy)) {
                  dist += " = Rastejando";
                  }
				  if (get_Swig(closestEnemy)) {
                  dist += " = Nadando";
                  }
				  if (get_Alid(closestEnemy)) {
                  dist += " = Salvando aliado";
                  }
				  if (get_Croc(closestEnemy)) {
                  dist += " = Agachado";
                  }
				  if (get_Grnd(closestEnemy)) {
                  dist += " = Com Granada";
                  }
				  if (get_Knif(closestEnemy)) {
                  dist += " = faca de arremesso";
				  } 
				  if (get_Cmfg(closestEnemy)) {
                  dist += " = Usando Camuflagem";
                  }
				  }
				  }
				  dist += " ]";
					
				
		          if (EspDistancia) {
		          esp.DrawText(TextColor, dist.c_str(), Vector3(PlayerRect.x + (PlayerRect.width / 2), PlayerRect.y + PlayerRect.height + 12.5f), TextSize);                                    
                  } 
			  
			      
			      if (EspVidav2) {
				  int Health = GetHp(closestEnemy);
				  float HpHeads = (ScreenHeight / (float)1080);
                  if (distance < 10) {
                     HP2 = 200;
                  } else if (distance > 10 && distance < 30) {
                     HP2 = 170;
                  } else if (distance > 30 && distance < 50) {
                     HP2 = 160;
                  } else if (distance > 50 && distance < 70) {
                     HP2 = 100;
                  } else if (distance > 70) {
                     HP2 = 100;
                  }
				  esp.DrawHorizontalHealthBar(Vector3(PlayerRect.x + (PlayerRect.width / 2), PlayerRect.y - 36.5f), (80 * HpHeads), HP2, Health);
                  }
				  }
				  
		          Vector3 screen(ScreenWidth, ScreenHeight);
		          float mScale = ScreenHeight / (float) 1080;
	              int borders = isOutsideSafezone(Head360, screen);
		          if (Esp360 && borders != 0) {
                  char DistEsp[128] = {};
		   
                  sprintf(DistEsp, "%.2f", distance);
		          Vector3 hintDotRenderPos = pushToScreenBorder(Head360, screen, borders, (int) ((mScale * 100) / 3));                                                           
                  Vector3 hintTextRenderPos = pushToScreenBorder(Head360, screen, borders, -(int) ((mScale * 36)));                                                                  
                  esp.DrawFilledCircle(Color360F, hintDotRenderPos, (mScale * 100));                                         
                  esp.DrawText(Cor360, DistEsp, hintTextRenderPos, 15);
                 }
             }
         }
     }
  }
}
}
}


Canvas *m_brunoView = 0;
void ESP_BrunoMods(JNIEnv *env, jclass clazz, jobject canvas, int SWidth, int SHeight, float screenDensity) {
