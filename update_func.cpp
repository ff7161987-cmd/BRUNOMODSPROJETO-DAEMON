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


